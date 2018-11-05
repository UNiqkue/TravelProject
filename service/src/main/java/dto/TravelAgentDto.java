package dto;

import java.util.Objects;
import java.util.UUID;

public class TravelAgentDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String activationCode;
    private String phoneNumber;
    private String position;
    private String nameTravelAgency;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNameTravelAgency() {
        return nameTravelAgency;
    }

    public void setNameTravelAgency(String nameTravelAgency) {
        this.nameTravelAgency = nameTravelAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgentDto that = (TravelAgentDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getActivationCode(), that.getActivationCode()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getPosition(), that.getPosition()) &&
                Objects.equals(getNameTravelAgency(), that.getNameTravelAgency());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmail(), getActivationCode(), getPhoneNumber(), getPosition(), getNameTravelAgency());
    }

    @Override
    public String toString() {
        return "TravelAgentDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", nameTravelAgency='" + nameTravelAgency + '\'' +
                '}';
    }
}
