package com.isicod.employee.management.service;


import com.isicod.employee.management.model.DemandeCongés;
import com.isicod.employee.management.repository.DemandeCongésRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeCongésService {
    @Autowired
    private DemandeCongésRepository demandeCongésRepository;

    public DemandeCongés save(DemandeCongés demandeCongés) {

        return demandeCongésRepository.save(demandeCongés);
    }

    public Optional<DemandeCongés> findById(Long id) {

        return demandeCongésRepository.findById(id);
    }

    public List<DemandeCongés> findAll() {
        return demandeCongésRepository.findAll();
    }

    public void deleteById(Long id) {
        demandeCongésRepository.deleteById(id);
    }
}

