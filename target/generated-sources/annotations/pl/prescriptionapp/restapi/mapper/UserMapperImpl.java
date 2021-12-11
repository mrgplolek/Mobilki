package pl.prescriptionapp.restapi.mapper;

import javax.annotation.processing.Generated;
import pl.prescriptionapp.restapi.dto.UserDto;
import pl.prescriptionapp.restapi.entity.UserEntity;
import pl.prescriptionapp.restapi.entity.UserEntity.UserEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T22:44:28+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDtoToUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.firstName( userDto.getFirstName() );
        userEntity.lastName( userDto.getLastName() );
        userEntity.email( userDto.getEmail() );
        userEntity.password( userDto.getPassword() );

        return userEntity.build();
    }
}
