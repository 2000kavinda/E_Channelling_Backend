package com.nsbm.echannelling.doctorservice.repository;

import com.nsbm.echannelling.doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    boolean existsByDrRegNo(Long drRegNo);

    //List<Doctor> findByDrNameAndTypeAndSpecialize(String drName, String type, String specialize);


    List<Doctor> findByDrName(String name);

    List<Doctor> findByType(String type);

    List<Doctor> findBySpecialize(String specialize);

    List<Doctor> findByDrNameAndType(String name, String type);

    List<Doctor> findByDrNameAndSpecialize(String name, String specialize);

    List<Doctor> findByTypeAndSpecialize(String type, String specialize);

    List<Doctor> findByDrNameAndTypeAndSpecialize(String name, String type, String specialize);

}
