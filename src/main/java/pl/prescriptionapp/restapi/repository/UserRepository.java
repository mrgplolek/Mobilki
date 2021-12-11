package pl.prescriptionapp.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prescriptionapp.restapi.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {
    UserEntity getUserEntityByEmail(String email);
}
