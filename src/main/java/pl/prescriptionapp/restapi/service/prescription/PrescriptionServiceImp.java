package pl.prescriptionapp.restapi.service.prescription;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.prescriptionapp.restapi.dto.PrescriptionDto;
import pl.prescriptionapp.restapi.entity.PrescriptionEntity;
import pl.prescriptionapp.restapi.mapper.PrescriptionMapper;
import pl.prescriptionapp.restapi.repository.PrescriptionRepository;
import pl.prescriptionapp.restapi.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImp implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final UserRepository userRepository;

    private final PrescriptionMapper prescriptionMapper = Mappers.getMapper(PrescriptionMapper.class);

    @Override
    public ResponseEntity<?> postPrescription(PrescriptionDto prescriptionDto){
        PrescriptionEntity prescriptionEntity = prescriptionMapper.prescriptionDtoToPrescriptionEntity(prescriptionDto, userRepository);

        prescriptionRepository.save(prescriptionEntity);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> updatePrescription(PrescriptionDto prescriptionDto){

        PrescriptionEntity prescriptionEntity = prescriptionRepository.findById(prescriptionDto.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (prescriptionDto.getCode() != null){
            prescriptionEntity.setCode(prescriptionDto.getCode());
        }
        if (prescriptionDto.getDescription() != null){
            prescriptionEntity.setDescription(prescriptionDto.getDescription());
        }
        if (prescriptionDto.getStatus() != null){
            prescriptionEntity.setStatus(prescriptionDto.getStatus());
        }
         prescriptionRepository.save(prescriptionEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getPrescription(Long id){
        PrescriptionEntity prescriptionEntity = prescriptionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(prescriptionEntity, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> getPrescriptionsByUser(Long userId){
        return new ResponseEntity<>(prescriptionRepository.getPrescriptionEntityByUser(userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> deletePrescription(Long id){
        prescriptionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
