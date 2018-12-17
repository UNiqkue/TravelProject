package com.netcracker.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.travel.entity.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String activationCode;

    private Role role;

    @JsonIgnore
    public String getActivationCode() {
        return this.activationCode;
    }

}
