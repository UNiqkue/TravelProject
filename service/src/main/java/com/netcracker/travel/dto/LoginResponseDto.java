package com.netcracker.travel.dto;

public class LoginResponseDto {

    private String token;
    private String activationCode;

    public LoginResponseDto(String token, String activationCode) {
        this.token = token;
        this.activationCode = activationCode;
    }


    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

