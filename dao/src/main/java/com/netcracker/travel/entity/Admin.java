package com.netcracker.travel.entity;

import com.netcracker.travel.entity.enumeration.Role;

import java.util.UUID;

public class Admin extends User {

    public Admin() {
    }

    public Admin(UUID id, String firstName, String lastName, String username, String password, String email, String activationCode) {
        super(id, firstName, lastName, username, password, email, activationCode);
    }

    @Override
    public void setRole(Role role) {
        super.setRole(role);
    }
}
