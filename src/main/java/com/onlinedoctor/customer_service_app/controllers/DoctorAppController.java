package com.onlinedoctor.customer_service_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinedoctor.customer_service_app.models.request.DoctorLoginRequest;
import com.onlinedoctor.customer_service_app.models.request.DoctorRegistrationRequest;
import com.onlinedoctor.customer_service_app.models.response.DoctorLoginResponse;
import com.onlinedoctor.customer_service_app.models.response.DoctorRegistrationReponse;
import com.onlinedoctor.customer_service_app.services.DoctorLookupService;
import com.onlinedoctor.customer_service_app.services.DoctorRegistrationService;


@RestController
@RequestMapping("doc")
public class DoctorAppController {

    @Autowired
    public DoctorRegistrationService doctorRegistrationService;
    @Autowired
    public DoctorLookupService doctorLookupService;

    @PostMapping("/register")
    public ResponseEntity<DoctorRegistrationReponse> doctorRegistration(@RequestBody DoctorRegistrationRequest docRegRequest) {
        var docEntity=doctorRegistrationService.addDoctorAccount(docRegRequest);
        var docRegResponse=doctorLookupService.docEntityToDocRegResponse(docEntity);
        return new ResponseEntity<>(docRegResponse,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<DoctorLoginResponse> docLogin(@RequestBody DoctorLoginRequest doctorLoginRequest){
        var docEntity=doctorLookupService.docLoginService(doctorLoginRequest);
        var docLoginResponse=doctorLookupService.docEntityToDocLogsResponse(docEntity);
        return new ResponseEntity<>(docLoginResponse,HttpStatus.FOUND);
    }
    
}
