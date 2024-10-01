package com.onlinedoctor.customer_service_app.services;
import org.springframework.stereotype.Service;

import com.onlinedoctor.customer_service_app.enitity.CustomerRegistrationEntity;
import com.onlinedoctor.customer_service_app.models.response.CustomerRegistrationResponse;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class CustomerLookupService {
     public CustomerRegistrationResponse toSignupResponse(CustomerRegistrationEntity customerEntity){
        val  customerRegistrationResponse=new CustomerRegistrationResponse();
        customerRegistrationResponse.setUserName(customerEntity.getUsername());
        customerRegistrationResponse.setFirstName(customerEntity.getFirstname());
        return customerRegistrationResponse;
     }
}
