package com.nsbm.echannelling.adminservice.service.implementation;

import com.nsbm.echannelling.adminservice.model.Credential;
import com.nsbm.echannelling.adminservice.model.LabPerson;
import com.nsbm.echannelling.adminservice.repository.CredentialsRepository;
import com.nsbm.echannelling.adminservice.repository.LabPersonRepository;
import com.nsbm.echannelling.adminservice.service.LabPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabPersonServiceImpl implements LabPersonService {

    @Autowired
    private LabPersonRepository labPersonRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    //get all lab person details
    @Override
    public ResponseEntity<?> getAllLabPerson() {
        try {
            return  ResponseEntity.ok(labPersonRepository.findAll());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * update the details of existing lab person
     * @param lPRegNo
     * @param newLabPerson
     * @return
     */
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

    /**
     * delete the existing lab person details from lab person and credential DBs
     * @param lPRegNo
     * @return
     */
    @Override
    public ResponseEntity<?>  deleteLabPerson(Long lPRegNo) {
        try {
            Optional<LabPerson> credentialOptional = labPersonRepository.findById(lPRegNo);
            if (credentialOptional.isPresent())
            {
                labPersonRepository.deleteById(lPRegNo);
                credentialsRepository.deleteById(lPRegNo);

                return ResponseEntity.ok("LabPerson deleted successfully");
            }else {
                return ResponseEntity.ok("LabPerson not found");
            }

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * search lab person by typing the name
     * @param lPName
     * @return
     */
    @Override
    public ResponseEntity<?> searchLabPersonByName(String lPName) {
        try {
            return ResponseEntity.ok(labPersonRepository.findByNameContaining(lPName));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
