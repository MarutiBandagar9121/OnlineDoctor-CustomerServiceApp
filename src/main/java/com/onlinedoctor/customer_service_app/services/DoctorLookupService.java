package com.onlinedoctor.customer_service_app.services;

import org.springframework.stereotype.Service;

import com.onlinedoctor.customer_service_app.enitity.DoctorEntity;
import com.onlinedoctor.customer_service_app.models.response.DoctorRegistrationReponse;

@Service
public class DoctorLookupService {
    
    public DoctorRegistrationReponse docEntityToDocResonse(DoctorEntity docEntity){
        var doctorRegistrationReponse=new DoctorRegistrationReponse();
        doctorRegistrationReponse.setFirstname(docEntity.getFirstname());
        doctorRegistrationReponse.setUsername(docEntity.getUsername());
        return doctorRegistrationReponse;
    }
}
