package com.nsbm.echannelling.patientservice.repository;

import java.util.List;
import com.nsbm.echannelling.patientservice.model.PatientDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientDoctorRepo extends JpaRepository<PatientDoctor, Long> {

    // Finds a list of PatientDoctor by  filtering their specialty
    List<PatientDoctor> findBySpecialize(String specialty);

    //query  to search for doctors based on multiple optional filters: name, specialty, and type
    @Query("SELECT pd FROM PatientDoctor pd WHERE " +
            "(:name IS NULL OR pd.drName LIKE %:name%) AND " +
            "(:specialty IS NULL OR pd.specialize LIKE %:specialty%) AND " +
            "(:type IS NULL OR pd.type LIKE %:type%)")
    List<PatientDoctor> searchDoctorsByFilter(@Param("name") String name,
                                              @Param("specialty") String specialty,
                                              @Param("type") String type);
}
