package com.netcracker.travel.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {

    public Admin() {
    }

    public Admin(String id, String firstName, String lastName, String username, String password, String email, String activationCode) {
        super(id, firstName, lastName, username, password, email, activationCode);
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
