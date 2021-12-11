package pl.prescriptionapp.restapi.service.medicine;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.prescriptionapp.restapi.dto.MedicineDto;
import pl.prescriptionapp.restapi.entity.MedicineEntity;
import pl.prescriptionapp.restapi.mapper.MedicineMapper;
import pl.prescriptionapp.restapi.repository.MedicineRepository;

@Service
@RequiredArgsConstructor
public class MedicineServiceImp implements MedicineService{

    private final MedicineRepository medicineRepository;

    private final MedicineMapper medicineMapper = Mappers.getMapper(MedicineMapper.class);

    @Override
    public ResponseEntity<?> postMedicine(MedicineDto medicineDto){
        MedicineEntity medicineEntity = medicineMapper.medicineDtoToMedicineEntity(medicineDto);

        medicineRepository.save(medicineEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> patchMedicine(MedicineDto medicineDto){
        MedicineEntity medicineEntity = medicineRepository.findById(medicineDto.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (medicineDto.getName() != null){
            medicineEntity.setName(medicineDto.getName());
        }
        if (medicineDto.getDose() != null){
            medicineEntity.setDose(medicineDto.getDose());
        }
        if (medicineDto.getType() != null){
            medicineEntity.setType(medicineDto.getType());
        }
        if (medicineDto.getManufacturer() != null){
            medicineEntity.setManufacturer(medicineDto.getManufacturer());
        }
        medicineRepository.save(medicineEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getMedicine(Long id){
        MedicineEntity medicineEntity = medicineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(medicineEntity, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> getMedicineByName(String name){
        return new ResponseEntity<>(medicineRepository.getMedicineEntityByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllMedicines(){
        return new ResponseEntity<>(medicineRepository.findAll(), HttpStatus.OK);
    }
}
