package pl.prescriptionapp.restapi.service.medicineassignment;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentDto;
import pl.prescriptionapp.restapi.dto.MedicineAssignmentsDto;
import pl.prescriptionapp.restapi.entity.MedicineAssignmentEntity;
import pl.prescriptionapp.restapi.mapper.MedicineAssignmentMapper;
import pl.prescriptionapp.restapi.repository.MedicineAssignmentRepository;
import pl.prescriptionapp.restapi.repository.MedicineRepository;
import pl.prescriptionapp.restapi.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineAssignmentServiceImp implements MedicineAssignmentService {

    private final MedicineAssignmentRepository medicineAssignmentRepository;
    private final MedicineAssignmentMapper medicineAssignmentMapper;

    private final UserRepository userRepository;
    private final MedicineRepository medicineRepository;


    @Override
    public ResponseEntity<?> postAssigment(MedicineAssignmentsDto medicineAssignmentsDto){
        List<MedicineAssignmentDto> listOfAssignmentDtos = new ArrayList<>();
        List<MedicineAssignmentEntity> listOfMedicineAssignmentEntity = new ArrayList<>();
        if (medicineAssignmentsDto != null && medicineAssignmentsDto.getNumberOfDosage() > 0){
            for (int i = 0; i < medicineAssignmentsDto.getNumberOfDosage(); i++){
                listOfAssignmentDtos.add(buildMedicineAssignmentDto(medicineAssignmentsDto, i));
            }

        }

        if (!listOfAssignmentDtos.isEmpty()){
            listOfAssignmentDtos.forEach(medicineAssignmentDto -> {
                MedicineAssignmentEntity medicineAssignmentEntity = medicineAssignmentMapper.medicineAssingmentDtoToMedicineAssignmentEntity(medicineAssignmentDto, userRepository, medicineRepository);
                listOfMedicineAssignmentEntity.add(medicineAssignmentRepository.save(medicineAssignmentEntity));
            });
            return new ResponseEntity<>(listOfMedicineAssignmentEntity, HttpStatus.CREATED);
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

   @Override
   public ResponseEntity<?> getAssignmentsByUser(Long userId){
       return new ResponseEntity<>(medicineAssignmentRepository.getMedicineAssignmentEntityByUser(userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))), HttpStatus.FOUND);
   }

   @Override
   public ResponseEntity<?> deleteAssignment(Long id){
        medicineAssignmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }


    private MedicineAssignmentDto buildMedicineAssignmentDto (MedicineAssignmentsDto medicineAssignmentsDto, int numOfDose){
        return MedicineAssignmentDto.builder()
                .dosageTime(medicineAssignmentsDto.getStartDate().plusMinutes((long) medicineAssignmentsDto.getDoseInterval() *numOfDose))
                .userId(medicineAssignmentsDto.getUser_id())
                .medicineId(medicineAssignmentsDto.getMedicine_id())
                .build();
    }
}
