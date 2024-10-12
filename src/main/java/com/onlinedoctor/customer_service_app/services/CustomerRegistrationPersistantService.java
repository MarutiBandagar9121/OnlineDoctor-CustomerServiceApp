package com.onlinedoctor.customer_service_app.services;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.onlinedoctor.customer_service_app.enitity.CustomerRegistrationEntity;
import com.onlinedoctor.customer_service_app.models.request.CustomerRegistraionRequest;
import com.onlinedoctor.customer_service_app.repository.CustomerRegistrationRepository;

@Service
@Slf4j

public class CustomerRegistrationPersistantService {
    private final CustomerRegistrationRepository customerRegistrationRepository;

    public CustomerRegistrationPersistantService(CustomerRegistrationRepository customerRegistrationRepository){
        this.customerRegistrationRepository = customerRegistrationRepository;

    }
    public CustomerRegistrationEntity addCustomerAccount(CustomerRegistraionRequest customerRegistrationRequest) {

        val customerRegistrationEntity=new CustomerRegistrationEntity();
        customerRegistrationEntity.setFirstname(customerRegistrationRequest.getFirstName());
        customerRegistrationEntity.setLastname(customerRegistrationRequest.getLastName());
        customerRegistrationEntity.setUsername(customerRegistrationRequest.getUserName());
        customerRegistrationEntity.setAge(customerRegistrationRequest.getAge());
        customerRegistrationEntity.setGender(customerRegistrationRequest.getGender());
        customerRegistrationEntity.setCity(customerRegistrationRequest.getCity());
        customerRegistrationEntity.setPincode(customerRegistrationRequest.getPincode());
        customerRegistrationEntity.setState(customerRegistrationRequest.getState());
        customerRegistrationEntity.setPassword(customerRegistrationRequest.getPassword());
        // System.out.println(" log:"+customerRegistrationEntity.getFirstname());
        return customerRegistrationRepository.save(customerRegistrationEntity);

    }
        
    
}
