package com.netcracker.travel.dto;

import com.netcracker.travel.entity.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelAgentDTO {

    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String activationCode;

    private String phoneNumber;

    private String position;

    private Role role;

}
