package com.nsbm.echannelling.adminservice.service.implementation;

import com.nsbm.echannelling.adminservice.repository.LabTestRepository;
import com.nsbm.echannelling.adminservice.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LabTestServiceImpl implements LabTestService {

    @Autowired
    private LabTestRepository labTestRepository;

    //retriview total of the lab tests available
    @Override
    public ResponseEntity<?> getLabTestCount() {
        try {
            long count = labTestRepository.count();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
