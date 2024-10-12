package com.onlinedoctor.customer_service_app.models.request;

import lombok.Data;

@Data
public class DoctorRegistrationRequest {
    private String username;
    private String lastname;
    private String firstname;
    private String qualification;
    private String yearsOfExperience;
    private String speciality;
    private int age;
    private String gender;
    private String city;
    private String state;
    private int pincode;
    private String password;
}
