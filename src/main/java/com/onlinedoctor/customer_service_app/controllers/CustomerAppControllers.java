package com.onlinedoctor.customer_service_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.onlinedoctor.customer_service_app.enitity.CustomerRegistrationEntity;
import com.onlinedoctor.customer_service_app.models.request.CustomerLoginRequest;
import com.onlinedoctor.customer_service_app.models.request.CustomerRegistraionRequest;
import com.onlinedoctor.customer_service_app.models.response.CustomerLoginResponse;
import com.onlinedoctor.customer_service_app.models.response.CustomerRegistrationResponse;
import com.onlinedoctor.customer_service_app.services.CustomerLookupService;
import com.onlinedoctor.customer_service_app.services.CustomerRegistrationPersistantService;

import lombok.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CustomerAppControllers {
    @Autowired
    private  CustomerRegistrationPersistantService customerRegistrationPersistantService;
    @Autowired
    private CustomerLookupService customerLookupService;
    
    @GetMapping("/")
    public ResponseEntity<String> getMethodName(@RequestParam(required = false) String param) {
        return ResponseEntity.ok("Customer service app working!!");
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomerRegistrationResponse> registerController(@RequestBody CustomerRegistraionRequest req) {
        CustomerRegistrationEntity customerRegistrationEntity=new CustomerRegistrationEntity();
        customerRegistrationEntity=customerRegistrationPersistantService.addCustomerAccount(req);
        val customerRegistrationResponse=customerLookupService.toSignupResponse(customerRegistrationEntity);
        return new ResponseEntity<>(customerRegistrationResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerLoginResponse> loginController(@RequestBody CustomerLoginRequest req) {
        val customerLoginResponse=customerLookupService.loginCheck(req);
        return new ResponseEntity<>(customerLoginResponse,HttpStatus.FOUND);
    }

    @PutMapping("update/{id}")
    public String putMethodName(@PathVariable String id) {
        return "The given id is "+id;
    }
}
