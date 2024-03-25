package com.example.onixpractice.services;


import com.example.onixpractice.dto.EmailRequest;


public interface EmailService {
    void sendEmail(EmailRequest emailRequest);

    void sendEmail(Long userId, String subject, String body);
}

