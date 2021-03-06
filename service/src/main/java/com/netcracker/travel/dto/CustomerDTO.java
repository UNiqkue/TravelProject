package com.netcracker.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.travel.entity.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String activationCode;

    private String phoneNumber;

    private String cardNumber;

    private String passportInfo;

    private Date dateOfBirth;

    private Role role;

    @JsonIgnore
    public String getActivationCode() {
        return this.activationCode;
    }
}
