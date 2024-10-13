package com.onlinedoctor.customer_service_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinedoctor.customer_service_app.enitity.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
    DoctorEntity findByUsernameAndPassword(String username, String password);
}
