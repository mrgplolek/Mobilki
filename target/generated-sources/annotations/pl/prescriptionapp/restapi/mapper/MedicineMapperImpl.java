package pl.prescriptionapp.restapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.prescriptionapp.restapi.dto.MedicineDto;
import pl.prescriptionapp.restapi.entity.MedicineEntity;
import pl.prescriptionapp.restapi.entity.MedicineEntity.MedicineEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T14:58:30+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class MedicineMapperImpl implements MedicineMapper {

    @Override
    public MedicineEntity medicineDtoToMedicineEntity(MedicineDto medicineDto) {
        if ( medicineDto == null ) {
            return null;
        }

        MedicineEntityBuilder medicineEntity = MedicineEntity.builder();

        medicineEntity.id( medicineDto.getId() );
        medicineEntity.name( medicineDto.getName() );
        medicineEntity.manufacturer( medicineDto.getManufacturer() );
        medicineEntity.type( medicineDto.getType() );
        medicineEntity.dose( medicineDto.getDose() );

        return medicineEntity.build();
    }
}
