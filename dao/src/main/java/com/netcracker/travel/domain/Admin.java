package com.netcracker.travel.domain;

import com.netcracker.travel.domain.abstracts.User;
import com.netcracker.travel.domain.enumeration.Role;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "admin")
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

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", activationCode='" + getActivationCode() + '\'' +
                ", role=" + getRole() +
                "}";
    }
}
