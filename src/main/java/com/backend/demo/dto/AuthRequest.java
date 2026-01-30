package com.backend.demo.dto;

public class AuthRequest {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    private String password;

    public AuthRequest() {}



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}