package com.onlinedoctor.customer_service_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctor.customer_service_app.enitity.DoctorEntity;
import com.onlinedoctor.customer_service_app.models.request.DoctorRegistrationRequest;
import com.onlinedoctor.customer_service_app.repository.DoctorRepository;

@Service
public class DoctorRegistrationService {
    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorRegistrationService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    public DoctorEntity addDoctorAccount(DoctorRegistrationRequest docRegRequest){
        DoctorEntity docEntity=new DoctorEntity();
        docEntity.setFirstname(docRegRequest.getFirstname());
        docEntity.setLastname(docRegRequest.getLastname());
        docEntity.setUsername(docRegRequest.getUsername());
        docEntity.setQualification(docRegRequest.getQualification());
        docEntity.setYearsOfExperience(docRegRequest.getYearsOfExperience());
        docEntity.setSpeciality(docRegRequest.getSpeciality());
        docEntity.setAge(docRegRequest.getAge());
        docEntity.setGender(docRegRequest.getGender());
        docEntity.setCity(docRegRequest.getCity());
        docEntity.setState(docRegRequest.getState());
        docEntity.setPincode(docRegRequest.getPincode());
        docEntity.setPassword(docRegRequest.getPassword());
        return doctorRepository.save(docEntity);
    }
}
