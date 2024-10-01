package com.onlinedoctor.customer_service_app.models.request;

import lombok.Data;

@Data
public class CustomerRegistraionRequest{
    private String  firstName;
    private String  lastName;
    private String  userName;
    private int  age;
    private String gender;
    private String  city;
    private int  pincode;
    private String state;
    private String  password;
    private String  confirmPassword;
}