package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.model.LabPerson;
import com.nsbm.echannelling.adminservice.service.implementation.LabPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/labperson")
public class LabPersonController {

    @Autowired
    private LabPersonServiceImpl labPersonService;

    //get all available lab person's details
    @GetMapping("/all")
    public ResponseEntity<?> getAllLabPerson() {
        return labPersonService.getAllLabPerson();

    }

    /**
     * update the existing selected lab person
     * @param lPRegNo
     * @param labPerson
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateLabPerson(@RequestParam Long lPRegNo, @RequestBody LabPerson labPerson) {
        return labPersonService.updateLabPerson(lPRegNo,labPerson);

    }

    /**
     * delete the existing selected lab person
     * @param lPRegNo
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLabPerson(@RequestParam Long lPRegNo) {
        return labPersonService.deleteLabPerson(lPRegNo);

    }

    /**
     * search the lab person by entering the name
     * @param name
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchLabPersonByName(@RequestParam String name) {
        return ResponseEntity.ok(labPersonService.searchLabPersonByName(name));
    }

}
