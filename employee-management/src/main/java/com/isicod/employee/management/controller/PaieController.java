package com.isicod.employee.management.controller;


import com.isicod.employee.management.model.Paie;
import com.isicod.employee.management.service.PaieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/payrolls")
public class PaieController {
    @Autowired
    private PaieService paieService;

    @GetMapping
    public String listPayrolls(Model model) {
        model.addAttribute("payrolls", paieService.findAll());
        return "payroll-list";
    }

    @GetMapping("/view/{id}")
    public String viewPayroll(@PathVariable Long id, Model model) {
        Optional<Paie> paie = paieService.findById(id);
        if (paie.isPresent()) {
            model.addAttribute("payroll", paie.get());
            return "payroll-view";
        } else {
            return "redirect:/payrolls";
        }
    }
}

