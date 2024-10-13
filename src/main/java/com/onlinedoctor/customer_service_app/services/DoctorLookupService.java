package com.onlinedoctor.customer_service_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctor.customer_service_app.enitity.DoctorEntity;
import com.onlinedoctor.customer_service_app.exception.LoginFailedException;
import com.onlinedoctor.customer_service_app.models.request.DoctorLoginRequest;
import com.onlinedoctor.customer_service_app.models.response.DoctorLoginResponse;
import com.onlinedoctor.customer_service_app.models.response.DoctorRegistrationReponse;
import com.onlinedoctor.customer_service_app.repository.DoctorRepository;

@Service
public class DoctorLookupService {
    @Autowired
    DoctorRepository doctorRepository;
    public DoctorRegistrationReponse docEntityToDocRegResponse(DoctorEntity docEntity){
        var doctorRegistrationReponse=new DoctorRegistrationReponse();
        doctorRegistrationReponse.setFirstname(docEntity.getFirstname());
        doctorRegistrationReponse.setUsername(docEntity.getUsername());
        return doctorRegistrationReponse;
    }

    public DoctorLoginResponse docEntityToDocLogsResponse(DoctorEntity docEntity){
        var docLoginResponse=new DoctorLoginResponse();
        docLoginResponse.setUsername(docEntity.getUsername());
        return docLoginResponse;
    }

    public DoctorEntity docLoginService(DoctorLoginRequest doctorLoginRequest){
        var docEntity=doctorRepository.findByUsernameAndPassword(doctorLoginRequest.getUsername(),doctorLoginRequest.getPassword());
        if(docEntity==null){
            throw new LoginFailedException(doctorLoginRequest.getUsername());
        }
        return docEntity;
    }
}
