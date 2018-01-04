package com.kurylo.domain;

import javax.persistence.*;

@Entity(name="registered_patients")
public class RegisteredPatients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String patient_name;

    @Column
    private String doctor_name;

    @Column
    private Long room_number;

    @Column
    private String aditional_comment;

    RegisteredPatients(){}

    public RegisteredPatients(String patient_name,String doctor_name, Long room_number, String aditional_comment){
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
        this.room_number = room_number;
        this.aditional_comment = aditional_comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public Long getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Long room_number) {
        this.room_number = room_number;
    }

    public String getAditional_comment() {
        return aditional_comment;
    }

    public void setAditional_comment(String aditional_comment) {
        this.aditional_comment = aditional_comment;
    }

    @Override
    public String toString() {
        return "RegisteredPatient [id= "+id+", patient_name= "+patient_name+", doctor_name= "+doctor_name+"," +
                " room_number ="+room_number+", aditional_comment="+aditional_comment+" ]";
    }
}
