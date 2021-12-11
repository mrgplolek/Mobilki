package pl.prescriptionapp.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.control.MappingControl;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="prescription")

public class PrescriptionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    @NotNull
    private Integer code;

    @Column(name="description")
    @Max(value = 255)
    @NotNull
    private String description;

    @Column(name = "status")
    @NotNull
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

}
