package pl.prescriptionapp.restapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.prescriptionapp.restapi.dto.MedicineDto;
import pl.prescriptionapp.restapi.entity.MedicineEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicineMapper {

    MedicineEntity medicineDtoToMedicineEntity (MedicineDto medicineDto);
}
