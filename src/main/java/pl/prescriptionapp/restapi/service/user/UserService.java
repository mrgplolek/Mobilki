package pl.prescriptionapp.restapi.service.user;

import org.springframework.http.ResponseEntity;
import pl.prescriptionapp.restapi.dto.UserDto;

public interface UserService {

    ResponseEntity<?> postUser(UserDto userDto);
    ResponseEntity<?> getUser(Long id, String password);
    ResponseEntity<?> loginUser(String email, String password);
}
