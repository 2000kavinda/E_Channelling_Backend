package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.model.LabPerson;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LabPersonService {
    ResponseEntity<?> getAllLabPerson();

    ResponseEntity<?>  updateLabPerson(Long lPRegNo, LabPerson newLabPerson);

    ResponseEntity<?> deleteLabPerson(Long lPRegNo);

    List<LabPerson> searchLabPersonByName(String lPName);
}
