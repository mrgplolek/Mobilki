package pl.prescriptionapp.restapi.service.user;


import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.prescriptionapp.restapi.dto.UserDto;
import pl.prescriptionapp.restapi.entity.UserEntity;
import pl.prescriptionapp.restapi.mapper.UserMapper;
import pl.prescriptionapp.restapi.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> postUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());

        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(userEntity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUser(Long id, String password) {
        var user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        if ((user.getPassword()).equals(password)){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> loginUser(String email, String password){
        var user = userRepository.getUserEntityByEmail(email);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            if (passwordEncoder.matches(password, user.getPassword())){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
    }




}
