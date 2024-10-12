package com.onlinedoctor.customer_service_app.enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "doctors")
@Data
public class DoctorEntity {

    @Id
    @Column(name = "username")
    private String username;
    
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "yearsofexperience")
    private String yearsOfExperience;

    @Column(name = "speciality")
    private String speciality;

    @Column(name="age")
    private int age;

    @Column(name="gender")
    private String gender;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="pincode")
    private int pincode;

    @Column(name="password")
    private String password;
}
