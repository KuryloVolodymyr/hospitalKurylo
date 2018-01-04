package com.kurylo.controller;

import com.kurylo.domain.RegisteredPatients;
import com.kurylo.service.RegisteredPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private RegisteredPatientsService registeredPatientsService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-patients")
    public String allPatients(HttpServletRequest request) {
        request.setAttribute("registeredPatients", registeredPatientsService.findAllPatients());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/new-patient")
    public String newPatient(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @GetMapping("/update-patient")
    public String updatePatient(@RequestParam Long id, HttpServletRequest request) {
        request.setAttribute("patient", registeredPatientsService.findPatient(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @GetMapping("/delete-patient")
    public String deletePatient(@RequestParam Long id, HttpServletRequest request) {
        registeredPatientsService.deletePatient(id);
        request.setAttribute("patients", registeredPatientsService.findAllPatients());
        request.setAttribute("mode", "MODE_OK");
        return "index";
    }

    @GetMapping("/ok")
    public String okResult(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/error")
    public String error(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }


    @PostMapping("/save-patient")
    public String savePatient(@ModelAttribute RegisteredPatients patient, BindingResult bindingResult, HttpServletRequest request) {
        registeredPatientsService.savePatient(patient);
        request.setAttribute("registeredPatients", registeredPatientsService.findAllPatients());
        request.setAttribute("mode", "MODE_OK");
        return "index";
    }

}
