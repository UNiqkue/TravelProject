package com.netcracker.travel.dto;

public class RegistrationRequestDto {

    private String username;
    private String password;
    private String email;
    private String alias;

    public RegistrationRequestDto(){}

    public RegistrationRequestDto(String username, String password, String email, String alias) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.alias = alias;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
