package dto;

import entity.enums.Role;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String activationCode;
    private Set<Role> role;

    public UserDto(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId()) &&
                Objects.equals(getFirstName(), userDto.getFirstName()) &&
                Objects.equals(getLastName(), userDto.getLastName()) &&
                Objects.equals(getUsername(), userDto.getUsername()) &&
                Objects.equals(getPassword(), userDto.getPassword()) &&
                Objects.equals(getEmail(), userDto.getEmail()) &&
                Objects.equals(getActivationCode(), userDto.getActivationCode()) &&
                Objects.equals(getRole(), userDto.getRole());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmail(), getActivationCode(), getRole());
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", role=" + role +
                '}';
    }
}
