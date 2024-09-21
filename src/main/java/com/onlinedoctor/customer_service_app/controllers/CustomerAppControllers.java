package com.onlinedoctor.customer_service_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.onlinedoctor.customer_service_app.models.request.CustomerLoginRequest;
import com.onlinedoctor.customer_service_app.models.request.CustomerRegistraionRequest;
import com.onlinedoctor.customer_service_app.models.response.CustomerLoginResponse;
import com.onlinedoctor.customer_service_app.models.response.CustomerRegistrationResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CustomerAppControllers {
    @GetMapping("/")
    public ResponseEntity<String> getMethodName(@RequestParam(required = false) String param) {
        return ResponseEntity.ok("Customer service app working!!");
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomerRegistrationResponse> registerController(@RequestBody CustomerRegistraionRequest req) {
        CustomerRegistrationResponse resp=new CustomerRegistrationResponse();
        resp.setFirstName(req.getFirstName());
        resp.setUserName(req.getUserName());
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerLoginResponse> loginController(@RequestBody CustomerLoginRequest req) {
        CustomerLoginResponse resp=new CustomerLoginResponse();
        resp.setUserName(req.getUserName());
        return ResponseEntity.ok(resp);
    }
}
