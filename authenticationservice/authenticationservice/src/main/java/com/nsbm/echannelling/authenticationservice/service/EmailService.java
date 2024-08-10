package com.nsbm.echannelling.authenticationservice.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
