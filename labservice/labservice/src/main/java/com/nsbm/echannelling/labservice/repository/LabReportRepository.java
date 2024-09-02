package com.nsbm.echannelling.labservice.repository;

import com.nsbm.echannelling.labservice.model.LabReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabReportRepository extends JpaRepository<LabReportModel, Long> {

    List<LabReportModel> findABypId(Long pid);

}
