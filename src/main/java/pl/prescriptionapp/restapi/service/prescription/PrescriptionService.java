package pl.prescriptionapp.restapi.service.prescription;

import org.springframework.http.ResponseEntity;
import pl.prescriptionapp.restapi.dto.PrescriptionDto;

public interface PrescriptionService {

    ResponseEntity<?> postPrescription(PrescriptionDto prescriptionDto);
    ResponseEntity<?> updatePrescription(PrescriptionDto prescriptionDto);
    ResponseEntity<?> getPrescription(Long id);
    ResponseEntity<?> getPrescriptionsByUser(Long userId);
    ResponseEntity<?> deletePrescription(Long id);
}
