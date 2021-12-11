package pl.prescriptionapp.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

    private Long id;
    private Integer code;
    private String description;
    private Integer status;
    private Long userId;
}
