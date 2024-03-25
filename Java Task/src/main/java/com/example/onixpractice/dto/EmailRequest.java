package com.example.onixpractice.dto;

public class EmailRequest {

    private Long userId;
    private String subject;
    private String body;

    // Default constructor
    public EmailRequest() {
    }

    // Parameterized constructor
    public EmailRequest(Long userId, String subject, String body) {
        this.userId = userId;
        this.subject = subject;
        this.body = body;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

