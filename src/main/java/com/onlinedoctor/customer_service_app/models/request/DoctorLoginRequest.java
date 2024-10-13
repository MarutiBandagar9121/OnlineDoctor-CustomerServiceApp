package com.onlinedoctor.customer_service_app.models.request;

import lombok.Data;

@Data
public class DoctorLoginRequest {
    String username;
    String password;
}
