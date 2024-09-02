package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.service.implementation.LabTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/labtest")
public class LabTestController {

    @Autowired
    private LabTestServiceImpl labTestService;

    //get total count of available lab tests
    @GetMapping("/count")
    public ResponseEntity<?> getLabTestCount() {
        return ResponseEntity.ok(labTestService.getLabTestCount());
    }

}
