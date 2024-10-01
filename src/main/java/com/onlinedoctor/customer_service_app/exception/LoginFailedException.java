package com.onlinedoctor.customer_service_app.exception;

public class LoginFailedException extends RuntimeException{

    private final String emailId;

    public LoginFailedException(String message, String emailId) {
        super(message);
        this.emailId = emailId;
    }

    public LoginFailedException(final String emailId) {
        super("Login failed : " + emailId);
        this.emailId = emailId;
    }
    
}
