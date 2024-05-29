package com.isicod.employee.management.service;


import com.isicod.employee.management.model.Paie;
import com.isicod.employee.management.repository.PaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaieService {
    @Autowired
    private PaieRepository paieRepository;

    public Paie save(Paie payroll) {
        return paieRepository.save(payroll);
    }

    public Optional<Paie> findById(Long id) {
        return paieRepository.findById(id);
    }

    public List<Paie> findAll() {
        return paieRepository.findAll();
    }

    public void deleteById(Long id) {
        paieRepository.deleteById(id);
    }
}

