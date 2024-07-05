package com.nsbm.echannelling.doctorservice.service;

import com.nsbm.echannelling.doctorservice.model.Doctor;
import com.nsbm.echannelling.doctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public boolean existsByDrRegNo(Long drRegNo) {
        return doctorRepository.existsByDrRegNo(drRegNo);
    }

    public List<Doctor> listAll(){
        return doctorRepository.findAll();
    }

    /*public List<Doctor> findByCriteria(String name, String type, String specialty) {
        return doctorRepository.findByDrNameAndTypeAndSpecialize(name, type, specialty);
    }*/

    public List<Doctor> findByCriteria(String name, String type, String specialty) {

        if (name != null && type != null && specialty != null) {
            return doctorRepository.findByDrNameAndTypeAndSpecialize(name, type, specialty);
        } else if (name != null && type != null) {
            return doctorRepository.findByDrNameAndType(name, type);
        } else if (name != null && specialty != null) {
            return doctorRepository.findByDrNameAndSpecialize(name, specialty);
        } else if (type != null && specialty != null) {
            return doctorRepository.findByTypeAndSpecialize(type, specialty);
        } else if (name != null) {
            return doctorRepository.findByDrName(name);
        } else if (type != null) {
            return doctorRepository.findByType(type);
        } else if (specialty != null) {
            return doctorRepository.findBySpecialize(specialty);
        } else {
            return doctorRepository.findAll();
        }
    }

}
