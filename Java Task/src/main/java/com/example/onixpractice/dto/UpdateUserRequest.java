package com.example.onixpractice.dto;

public class UpdateUserRequest {

    private String username;
    private String email;

    // Default constructor
    public UpdateUserRequest() {
    }

    // Parameterized constructor
    public UpdateUserRequest(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
