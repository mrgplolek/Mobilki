package pl.prescriptionapp.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prescriptionapp.restapi.entity.MedicineEntity;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository <MedicineEntity, Long> {

    List<MedicineEntity> getMedicineEntityByName(String name);
}
