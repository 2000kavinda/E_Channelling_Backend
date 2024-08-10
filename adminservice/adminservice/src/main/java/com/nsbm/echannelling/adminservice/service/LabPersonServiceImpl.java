package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.model.LabPerson;
import com.nsbm.echannelling.adminservice.repository.LabPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabPersonServiceImpl implements LabPersonService {

    @Autowired
    private LabPersonRepository labPersonRepository;

    @Override
    public ResponseEntity<?> getAllLabPerson() {
        try {
            return  ResponseEntity.ok(labPersonRepository.findAll());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @Override
    public ResponseEntity<?>  updateLabPerson(Long lPRegNo, LabPerson newLabPerson) {
        try {
            Optional<LabPerson> credentialOptional = labPersonRepository.findById(lPRegNo);
            LabPerson labPerson = credentialOptional.get();
            labPerson.setLPName(newLabPerson.getLPName());
            labPerson.setLabNo(newLabPerson.getLabNo());
            labPerson.setLPQualification(newLabPerson.getLPQualification());


            return  ResponseEntity.ok(labPersonRepository.save(labPerson));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?>  deleteLabPerson(Long lPRegNo) {
        try {
            Optional<LabPerson> credentialOptional = labPersonRepository.findById(lPRegNo);
            if (credentialOptional.isPresent())
            {
                labPersonRepository.deleteById(lPRegNo);

                return ResponseEntity.ok("LabPerson deleted successfully");
            }else {
                return ResponseEntity.ok("LabPerson not found");
            }

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public List<LabPerson> searchLabPersonByName(String lPName) {
        return labPersonRepository.findByNameContaining(lPName);
    }
}
