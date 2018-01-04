package com.kurylo.service;

import com.kurylo.domain.RegisteredPatients;
import com.kurylo.repository.RegisteredPatientsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisteredPatientsService {

    private RegisteredPatientsRepository registeredPatientsRepository;

    public RegisteredPatientsService(RegisteredPatientsRepository registeredPatientsRepository){
        this.registeredPatientsRepository = registeredPatientsRepository;
    }

    public List<RegisteredPatients> findAllPatients(){
        List<RegisteredPatients> patients = new ArrayList<RegisteredPatients>();
        for(RegisteredPatients patient:  registeredPatientsRepository.findAll())
            patients.add(patient);
        return patients;
    }

    public void savePatient(RegisteredPatients registeredPatients){
        registeredPatientsRepository.save(registeredPatients);
    }

    public void deletePatient(Long id){
        registeredPatientsRepository.delete(id);
    }

    public RegisteredPatients findPatient(Long id){
        return registeredPatientsRepository.findOne(id);
    }

}

