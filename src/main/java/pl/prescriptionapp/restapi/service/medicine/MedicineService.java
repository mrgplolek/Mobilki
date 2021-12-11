package pl.prescriptionapp.restapi.service.medicine;

import org.springframework.http.ResponseEntity;
import pl.prescriptionapp.restapi.dto.MedicineDto;

public interface MedicineService {

    ResponseEntity<?> postMedicine(MedicineDto medicineDto);
    ResponseEntity<?> patchMedicine(MedicineDto medicineDto);
    ResponseEntity<?> getMedicine(Long id);
    ResponseEntity<?> getMedicineByName(String name);
    ResponseEntity<?> getAllMedicines();
}
