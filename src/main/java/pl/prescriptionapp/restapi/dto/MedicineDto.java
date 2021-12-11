package pl.prescriptionapp.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {

    private Long id;
    private String name;
    private String manufacturer;
    private String type;
    private Float dose;
}
