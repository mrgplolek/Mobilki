package pl.prescriptionapp.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @Max(value = 255)
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @Max(value = 255)
    @NotNull
    private String lastName;

    @Column(name = "email")
    @Max(value = 255)
    @Email
    @NotNull
    private String email;

    @Column(name = "password")
    @Max(value = 255)
    @NotNull
    private String password;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<PrescriptionEntity> prescriptions;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<MedicineAssignmentEntity> medicineAssignments;
}
