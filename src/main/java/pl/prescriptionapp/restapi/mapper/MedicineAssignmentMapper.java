package pl.prescriptionapp.restapi.mapper;

import org.mapstruct.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentDto;
import pl.prescriptionapp.restapi.entity.MedicineAssignmentEntity;
import pl.prescriptionapp.restapi.entity.MedicineEntity;
import pl.prescriptionapp.restapi.entity.UserEntity;
import pl.prescriptionapp.restapi.repository.MedicineRepository;
import pl.prescriptionapp.restapi.repository.UserRepository;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicineAssignmentMapper {
    @Mapping(source = "userId", target = "user", qualifiedByName = "getUserEntity")
    @Mapping(source = "medicineId", target = "medicine", qualifiedByName = "getMedicineEntity")
    MedicineAssignmentEntity medicineAssingmentDtoToMedicineAssignmentEntity(MedicineAssignmentDto medicineAssignmentDto, @Context UserRepository userRepository, @Context MedicineRepository medicineRepository);

    @Named("getUserEntity")
    default UserEntity getUserEntity(Long userId, @Context UserRepository userRepository) {
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Named("getMedicineEntity")
    default MedicineEntity getMedicineEntity(Long medicineId, @Context MedicineRepository medicineRepository) {
        return medicineRepository.findById(medicineId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
}