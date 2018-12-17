package com.netcracker.travel.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    @ApiModelProperty(hidden = true)
    private String activationCode;

    private String phoneNumber;

    private String cardNumber;

    private String passportInfo;

    private Date dateOfBirth;

}
