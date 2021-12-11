package pl.prescriptionapp.restapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="medicine")
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Max(value = 255)
    private String name;

    @Column(name = "manufacturer")
    @NotNull
    @Max(value = 255)
    private String manufacturer;

    @Column(name = "type")
    @NotNull
    @Max(value = 255)
    private String type;

    @Column(name = "dose")
    @NotNull
    private Float dose;

    @OneToMany(
            mappedBy = "medicine",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<MedicineAssignmentEntity> medicineAssignments;
}
