package com.onlinedoctor.customer_service_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlinedoctor.customer_service_app.models.request.DoctorRegistrationRequest;
import com.onlinedoctor.customer_service_app.models.response.DoctorRegistrationReponse;
import com.onlinedoctor.customer_service_app.services.DoctorLookupService;
import com.onlinedoctor.customer_service_app.services.DoctorRegistrationService;


@Controller
public class DoctorAppController {

    @Autowired
    public DoctorRegistrationService doctorRegistrationService;
    @Autowired
    public DoctorLookupService doctorLookupService;
    
    @PostMapping("/doc/register")
    public DoctorRegistrationReponse doctorRegistration(@RequestBody DoctorRegistrationRequest docRegRequest) {
        var docEntity=doctorRegistrationService.addDoctorAccount(docRegRequest);
        var docRegResponse=doctorLookupService.docEntityToDocResonse(docEntity);
        return docRegResponse;
    }
    
}
