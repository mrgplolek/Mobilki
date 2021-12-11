package pl.prescriptionapp.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.prescriptionapp.restapi.entity.MedicineEntity;
import pl.prescriptionapp.restapi.entity.UserEntity;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicineAssignmentDto {

    private OffsetDateTime dosageTime;
    private Long userId;
    private Long medicineId;
}
