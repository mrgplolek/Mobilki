package pl.prescriptionapp.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prescriptionapp.restapi.dto.MedicineDto;
import pl.prescriptionapp.restapi.service.medicine.MedicineService;

@RestController
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getMedicineById(@PathVariable Long id){
        return medicineService.getMedicine(id);
    }

    @GetMapping("/byName")
    @ResponseBody
    public ResponseEntity<?> getMedicineByName(@RequestParam String name){
        return medicineService.getMedicineByName(name);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createMedicine(@RequestBody MedicineDto medicineDto){
        return medicineService.postMedicine(medicineDto);
    }

    @PatchMapping
    @ResponseBody
    public ResponseEntity<?> updateMedicine(@RequestBody MedicineDto medicineDto){
        return medicineService.patchMedicine(medicineDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllMedicines(){
        return medicineService.getAllMedicines();
    }
}
