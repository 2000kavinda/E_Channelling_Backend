package com.nsbm.echannelling.labservice.repository;

import com.nsbm.echannelling.labservice.model.LabModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabServiceRepository extends JpaRepository<LabModel, Long> {
    boolean existsByServiceName(String serviceName);
    isexistbyservicename,
}
