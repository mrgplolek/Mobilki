package pl.prescriptionapp.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prescriptionapp.restapi.entity.MedicineAssignmentEntity;
import pl.prescriptionapp.restapi.entity.MedicineEntity;
import pl.prescriptionapp.restapi.entity.PrescriptionEntity;
import pl.prescriptionapp.restapi.entity.UserEntity;

import java.util.List;

@Repository
public interface MedicineAssignmentRepository extends JpaRepository <MedicineAssignmentEntity, Long> {

    List<MedicineAssignmentEntity> getMedicineAssignmentEntityByUserAndMedicine(UserEntity userEntity, MedicineEntity medicineEntity);
    List<MedicineAssignmentEntity> getMedicineAssignmentEntityByUser(UserEntity user);
}
