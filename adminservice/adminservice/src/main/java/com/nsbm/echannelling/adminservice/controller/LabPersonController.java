package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.model.LabPerson;
import com.nsbm.echannelling.adminservice.service.implementation.LabPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/labperson")
public class LabPersonController {

    @Autowired
    private LabPersonServiceImpl labPersonService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllLabPerson() {
        return labPersonService.getAllLabPerson();

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateLabPerson(@RequestParam Long lPRegNo, @RequestBody LabPerson labPerson) {
        return labPersonService.updateLabPerson(lPRegNo,labPerson);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLabPerson(@RequestParam Long lPRegNo) {
        return labPersonService.deleteLabPerson(lPRegNo);

    }

    @GetMapping("/search")
    public ResponseEntity<?> searchLabPersonByName(@RequestParam String name) {
        return ResponseEntity.ok(labPersonService.searchLabPersonByName(name));
    }

}
