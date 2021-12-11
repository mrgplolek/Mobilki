package pl.prescriptionapp.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.prescriptionapp.restapi.entity.PrescriptionEntity;
import pl.prescriptionapp.restapi.entity.UserEntity;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long> {

    List<PrescriptionEntity> getPrescriptionEntityByUser(UserEntity user);
}

