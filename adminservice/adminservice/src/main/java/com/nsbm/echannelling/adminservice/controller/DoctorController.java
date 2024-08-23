package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.model.Doctor;
import com.nsbm.echannelling.adminservice.service.implementation.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    // get the total available DR count
    @GetMapping("/count")
    public ResponseEntity<?> getDoctorCount() {
        return ResponseEntity.ok(doctorService.getDoctorCount());
    }

    //get all DR details
    @GetMapping("/all")
    public ResponseEntity<?> getAllDoctor() {
        return doctorService.getAllDoctors();

    }

    /**
     * update the existing selected DR
     * @param drRegNo
     * @param doctor
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateDoctor(@RequestParam Long drRegNo, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(drRegNo,doctor);

    }

    /**
     * delete the existing selected DR
     * @param drRegNo
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteDoctor(@RequestParam Long drRegNo) {
        return doctorService.deleteDoctor(drRegNo);

    }

    /**
     * search the available DRs by typing the name
     * @param name
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchLabPersonByName(@RequestParam String name) {
        return ResponseEntity.ok(doctorService.searchDoctorByName(name));
    }

}
