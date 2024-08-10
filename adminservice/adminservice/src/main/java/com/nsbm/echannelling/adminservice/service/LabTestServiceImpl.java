package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LabTestServiceImpl implements LabTestService{

    @Autowired
    private LabTestRepository labTestRepository;

    @Override
    public ResponseEntity<?> getLabTestCount() {
        try {
            long count = labTestRepository.count();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
}
