package com.kurylo.controller;

import com.kurylo.domain.RegisteredPatients;
import com.kurylo.service.RegisteredPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private RegisteredPatientsService registeredPatientsService;

//   @RequestMapping("/hello")
//   public String hello(){
//       return "Hello World!!!";
//   }
//
//   @RequestMapping("/view/all")
//   public String allPatients(){
//        return registeredPatientsService.findAllPatients().toString();
//   }
//
//   @RequestMapping("/save")
//    public String savePatient(@RequestParam String patient_name, @RequestParam String doctor_name, @RequestParam Long room_number,
//   @RequestParam String aditional_comment){
//       registeredPatientsService.savePatient(new RegisteredPatients(patient_name, doctor_name, room_number, aditional_comment));
//       return "Patient saved";
//   }
//
//   @RequestMapping("/delete")
//    public String deletePatient(Long id){
//        registeredPatientsService.deletePatient(id);
//        return "Patient Deleted";
//   }

}
