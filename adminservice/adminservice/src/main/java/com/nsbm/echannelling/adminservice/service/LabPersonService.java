package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.model.LabPerson;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LabPersonService {
    ResponseEntity<?> getAllLabPerson();

    //get all lab person details
    ResponseEntity<?> getALabPerson(Long lPRegNo);

    ResponseEntity<?>  updateLabPerson(Long lPRegNo, LabPerson newLabPerson);

    ResponseEntity<?> deleteLabPerson(Long lPRegNo);

    ResponseEntity<?> searchLabPersonByName(String lPName);
}
