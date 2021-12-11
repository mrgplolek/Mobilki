package pl.prescriptionapp.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prescriptionapp.restapi.dto.PrescriptionDto;
import pl.prescriptionapp.restapi.service.prescription.PrescriptionService;


@RestController
@RequestMapping("/prescription")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        return prescriptionService.postPrescription(prescriptionDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePrescription(@RequestBody PrescriptionDto prescriptionDto){
        return prescriptionService.updatePrescription(prescriptionDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrescriptionById(@PathVariable Long id){
        return prescriptionService.getPrescription(id);
    }

    @GetMapping
    public ResponseEntity<?> getPrescriptionByUser(@RequestParam Long userId){
        return prescriptionService.getPrescriptionsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrescriptionById(@PathVariable Long id){
        return prescriptionService.deletePrescription(id);
    }
}
