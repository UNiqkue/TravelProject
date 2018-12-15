package com.netcracker.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDto {

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

}
