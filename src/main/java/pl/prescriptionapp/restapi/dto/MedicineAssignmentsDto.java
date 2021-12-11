package pl.prescriptionapp.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MedicineAssignmentsDto {

    private Integer doseInterval;
    private OffsetDateTime startDate;
    private Integer numberOfDosage;
    private Long user_id;
    private Long medicine_id;
}
