package com.netcracker.travel.entity;

import com.netcracker.travel.entity.abstracts.BaseEntity;
import com.netcracker.travel.entity.enumeration.Role;

import java.util.Objects;
import java.util.Set;

public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String activationCode;
    private Set<Role> role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", role=" + role +
                '}';
    }
}
