package com.nsbm.echannelling.patientservice.repository;

import java.util.List;
import com.nsbm.echannelling.patientservice.model.Patient_Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Patient_DoctorRepo extends JpaRepository<Patient_Doctor, Long> {

    List<Patient_Doctor> findBySpecialize(String specialty);

    @Query("SELECT pd FROM Patient_Doctor pd WHERE " +
            "(:name IS NULL OR pd.drName LIKE %:name%) AND " +
            "(:specialty IS NULL OR pd.specialize LIKE %:specialty%) AND " +
            "(:type IS NULL OR pd.type LIKE %:type%)")
    List<Patient_Doctor> searchDoctorsByFilter(@Param("name") String name,
                                                @Param("specialty") String specialty,
                                                @Param("type") String type);
}
