package com.nsbm.echannelling.labservice.controller;

import com.nsbm.echannelling.labservice.model.LabModel;
import com.nsbm.echannelling.labservice.service.implementation.LabServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/LabService")
public class LabController {

    @Autowired
    private LabServiceImpl labService;
    /**
     * add new lab service
     * @param lab
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody LabModel lab) {
        try {
            if (labService.isExistsByServiceName(lab.getServiceName())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Service name " + lab.getServiceName() + " already exists");
            }
            labService.save(lab);
            return ResponseEntity.status(HttpStatus.CREATED).body("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }
    /**
     * delete selected lab service
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            if (!labService.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lab service not found");
            }
            labService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Lab service deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }
    /**
     * update selected lab service
     * @param id
     * @param lab
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody LabModel lab) {
        try {
            if (!labService.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lab service not found");
            }
            LabModel existingLab = labService.findById(id);
            existingLab.setServiceName(lab.getServiceName());
            existingLab.setDescription(lab.getDescription());
            existingLab.setPrice(lab.getPrice());
            labService.save(existingLab);
            return ResponseEntity.status(HttpStatus.OK).body("Lab service updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }
    /**
     * view selected lab service data
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    public ResponseEntity<LabModel> view(@PathVariable Long id) {
        try {
            if (!labService.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            LabModel lab = labService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(lab);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    /**
     * view all lab services
     * @return
     */
    @GetMapping("/viewAll")
    public ResponseEntity<List<LabModel>> viewAll() {
        try {
            List<LabModel> labs = labService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(labs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
