package pl.prescriptionapp.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentDto;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentsDto;
import pl.prescriptionapp.restapi.service.medicineassignment.MedicineAssignmentService;

@RestController
@RequestMapping("/drugsassignment")
@RequiredArgsConstructor
public class MedicineAssigmentController {

    private final MedicineAssignmentService medicineAssignmentService;

    @PostMapping
    public ResponseEntity<?> createAssignment(@RequestBody MedicineAssignmentsDto medicineAssignmentsDto){
        return medicineAssignmentService.postAssigment(medicineAssignmentsDto);
    }

    @GetMapping
    public ResponseEntity<?> getAssignmentsByUser(@RequestParam Long userId){
        return medicineAssignmentService.getAssignmentsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long id){
        return medicineAssignmentService.deleteAssignment(id);
    }

}
