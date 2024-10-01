package com.onlinedoctor.customer_service_app.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctor.customer_service_app.enitity.CustomerRegistrationEntity;
import com.onlinedoctor.customer_service_app.exception.LoginFailedException;
import com.onlinedoctor.customer_service_app.models.request.CustomerLoginRequest;
import com.onlinedoctor.customer_service_app.models.response.CustomerLoginResponse;
import com.onlinedoctor.customer_service_app.models.response.CustomerRegistrationResponse;
import com.onlinedoctor.customer_service_app.repository.CustomerRegistrationRepository;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class CustomerLookupService {
    @Autowired
    private CustomerRegistrationRepository customerRegistrationRepository;
    public CustomerRegistrationResponse toSignupResponse(CustomerRegistrationEntity customerEntity){
        val  customerRegistrationResponse=new CustomerRegistrationResponse();
        customerRegistrationResponse.setUserName(customerEntity.getUsername());
        customerRegistrationResponse.setFirstName(customerEntity.getFirstname());
        return customerRegistrationResponse;
    }

    public CustomerLoginResponse customerRegistrationEntityToCustomerLoginResponse(CustomerRegistrationEntity customerRegistrationEntity){
        val customerLoginResponse=new CustomerLoginResponse();
        customerLoginResponse.setUserName(customerRegistrationEntity.getUsername());
        return customerLoginResponse;
    }

    public CustomerLoginResponse loginCheck(CustomerLoginRequest loginRequest){
        val customerRegistrationEntity=customerRegistrationRepository.findUserByUsernameAndPassword(loginRequest.getUserName(),loginRequest.getPassword());
        if (customerRegistrationEntity == null) {
            throw new LoginFailedException(loginRequest.getUserName());
        }
        val customerLoginResponse=customerRegistrationEntityToCustomerLoginResponse(customerRegistrationEntity);
        return customerLoginResponse;
    }
}
