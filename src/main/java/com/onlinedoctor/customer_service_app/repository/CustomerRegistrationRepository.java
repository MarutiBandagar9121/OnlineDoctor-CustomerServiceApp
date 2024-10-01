package com.onlinedoctor.customer_service_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinedoctor.customer_service_app.enitity.CustomerRegistrationEntity;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationEntity,String> {
    CustomerRegistrationEntity findUserByUsernameAndPassword(String username, String password);
}
