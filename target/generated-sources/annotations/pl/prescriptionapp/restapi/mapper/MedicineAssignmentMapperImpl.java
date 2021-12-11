package pl.prescriptionapp.restapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentDto;
import pl.prescriptionapp.restapi.entity.MedicineAssignmentEntity;
import pl.prescriptionapp.restapi.entity.MedicineAssignmentEntity.MedicineAssignmentEntityBuilder;
import pl.prescriptionapp.restapi.repository.MedicineRepository;
import pl.prescriptionapp.restapi.repository.UserRepository;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T14:58:30+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class MedicineAssignmentMapperImpl implements MedicineAssignmentMapper {

    @Override
    public MedicineAssignmentEntity medicineAssingmentDtoToMedicineAssignmentEntity(MedicineAssignmentDto medicineAssignmentDto, UserRepository userRepository, MedicineRepository medicineRepository) {
        if ( medicineAssignmentDto == null ) {
            return null;
        }

        MedicineAssignmentEntityBuilder medicineAssignmentEntity = MedicineAssignmentEntity.builder();

        medicineAssignmentEntity.user( getUserEntity( medicineAssignmentDto.getUserId(), userRepository ) );
        medicineAssignmentEntity.medicine( getMedicineEntity( medicineAssignmentDto.getMedicineId(), medicineRepository ) );
        medicineAssignmentEntity.dosageTime( medicineAssignmentDto.getDosageTime() );

        return medicineAssignmentEntity.build();
    }
}
