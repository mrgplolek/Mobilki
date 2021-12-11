package pl.prescriptionapp.restapi.service.medicineassignment;

import org.springframework.http.ResponseEntity;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentDto;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentsDto;

public interface MedicineAssignmentService {
    ResponseEntity<?> postAssigment(MedicineAssignmentsDto medicineAssignmentsDto);
    ResponseEntity<?> getAssignmentsByUser(Long userId);
    ResponseEntity<?> deleteAssignment(Long id);
}
