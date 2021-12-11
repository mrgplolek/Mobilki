package pl.prescriptionapp.restapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.prescriptionapp.restapi.dto.PrescriptionDto;
import pl.prescriptionapp.restapi.entity.PrescriptionEntity;
import pl.prescriptionapp.restapi.entity.PrescriptionEntity.PrescriptionEntityBuilder;
import pl.prescriptionapp.restapi.repository.UserRepository;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T14:58:30+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class PrescriptionMapperImpl implements PrescriptionMapper {

    @Override
    public PrescriptionEntity prescriptionDtoToPrescriptionEntity(PrescriptionDto prescriptionDto, UserRepository userRepository) {
        if ( prescriptionDto == null ) {
            return null;
        }

        PrescriptionEntityBuilder prescriptionEntity = PrescriptionEntity.builder();

        prescriptionEntity.user( getUserEntity( prescriptionDto.getUserId(), userRepository ) );
        prescriptionEntity.id( prescriptionDto.getId() );
        prescriptionEntity.code( prescriptionDto.getCode() );
        prescriptionEntity.description( prescriptionDto.getDescription() );
        prescriptionEntity.status( prescriptionDto.getStatus() );

        return prescriptionEntity.build();
    }
}
