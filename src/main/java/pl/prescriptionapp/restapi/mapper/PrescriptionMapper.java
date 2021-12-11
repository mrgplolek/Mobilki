package pl.prescriptionapp.restapi.mapper;

import org.mapstruct.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import pl.prescriptionapp.restapi.dto.PrescriptionDto;
import pl.prescriptionapp.restapi.entity.PrescriptionEntity;
import pl.prescriptionapp.restapi.entity.UserEntity;
import pl.prescriptionapp.restapi.repository.UserRepository;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PrescriptionMapper {

    @Mapping(source = "userId", target = "user", qualifiedByName = "getUserEntity")
    PrescriptionEntity prescriptionDtoToPrescriptionEntity(PrescriptionDto prescriptionDto, @Context UserRepository userRepository);

    @Named("getUserEntity")
    default UserEntity getUserEntity (Long userId, @Context UserRepository userRepository){
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
