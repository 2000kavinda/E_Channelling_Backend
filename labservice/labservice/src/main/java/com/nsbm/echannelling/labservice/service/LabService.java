package com.nsbm.echannelling.labservice.service;

import com.nsbm.echannelling.labservice.model.LabModel;

import java.util.List;

public interface LabService {
    boolean isExistsByServiceName(String serviceName);

    void save(LabModel labModel);

    boolean existsById(Long id);

    void deleteById(Long id);

    LabModel findById(Long id);

    List<LabModel> findAll();
}
