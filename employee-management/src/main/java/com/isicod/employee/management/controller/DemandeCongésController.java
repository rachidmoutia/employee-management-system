package com.isicod.employee.management.controller;


import com.isicod.employee.management.model.DemandeCongés;
import com.isicod.employee.management.model.Employee;
import com.isicod.employee.management.service.DemandeCongésService;
import com.isicod.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/leaves")
public class DemandeCongésController {
    @Autowired
    private DemandeCongésService demandeCongésService;

    @Autowired
    private EmployeeService employeeService;

    //Lister toutes les demandes de congés
    @GetMapping
    public String listLeaveRequests(Model model) {
        model.addAttribute("leaves", demandeCongésService.findAll());
        return "leave-list";
    }

    //Méthode pour afficher le formulaire de création de demande de congé
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Employee> employees = employeeService.findAll(); // Récupérer la liste des employés
        model.addAttribute("employees", employees);
        model.addAttribute("leaveRequest", new DemandeCongés());
        return "leave-form";
    }

    //Méthode pour créer une nouvelle demande de congé
    @PostMapping("/create")
    public String createLeaveRequest(@ModelAttribute DemandeCongés demandeCongés) {
        if(demandeCongés != null) {
            demandeCongés.setStatus("Pending");
            demandeCongésService.save(demandeCongés);
        }
        return "redirect:/leaves";
    }

    //Méthode pour afficher le formulaire d'édition de demande de congé
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<DemandeCongés> demandeCongés = demandeCongésService.findById(id);
        if (demandeCongés.isPresent()) {
            model.addAttribute("leaveRequest", demandeCongés.get());
            return "leave-form";
        } else {
            return "redirect:/leaves";
        }
    }

    //Méthode pour mettre à jour une demande de congé
    @PostMapping("/edit/{id}")
    public String updateLeaveRequest(@PathVariable Long id, @ModelAttribute DemandeCongés demandeCongés) {
        demandeCongés.setId(id);
        demandeCongésService.save(demandeCongés);
        return "redirect:/leaves";
    }

    //Méthode pour supprimer une demande de congé
    @GetMapping("/delete/{id}")
    public String deleteLeaveRequest(@PathVariable Long id) {
        demandeCongésService.deleteById(id);
        return "redirect:/leaves";
    }
}

