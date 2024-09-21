package com.onlinedoctor.customer_service_app.models.request;

import lombok.Data;

@Data
public class CustomerLoginRequest {
    String userName;
    String password;
}
