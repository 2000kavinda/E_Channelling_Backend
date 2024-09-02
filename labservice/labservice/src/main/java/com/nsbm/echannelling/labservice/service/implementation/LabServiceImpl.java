package com.nsbm.echannelling.labservice.service.implementation;

import com.nsbm.echannelling.labservice.model.LabModel;
import com.nsbm.echannelling.labservice.repository.LabServiceRepository;
import com.nsbm.echannelling.labservice.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabServiceImpl implements LabService {

    @Autowired
    private LabServiceRepository labServiceRepository;

    @Override
    public boolean existsByServiceName(String serviceName) {
        return labServiceRepository.existsByServiceName(serviceName);
    }

    @Override
    public void save(LabModel labModel) {
        labServiceRepository.save(labModel);
    }

    @Override
    public boolean existsById(Long id) {
        return labServiceRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        labServiceRepository.deleteById(id);
    }

    @Override
    public LabModel findById(Long id) {
        return labServiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<LabModel> findAll() {
        return labServiceRepository.findAll();
    }
}
