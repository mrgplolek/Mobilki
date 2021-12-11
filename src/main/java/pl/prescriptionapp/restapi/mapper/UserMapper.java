package pl.prescriptionapp.restapi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.prescriptionapp.restapi.dto.UserDto;
import pl.prescriptionapp.restapi.entity.UserEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserEntity userDtoToUserEntity(UserDto userDto);
}
