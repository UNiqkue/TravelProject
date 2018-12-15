package com.netcracker.travel.dto;

import com.netcracker.travel.domain.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String activationCode;

    private Role role;

}
