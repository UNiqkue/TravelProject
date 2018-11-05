package dto;

import entity.Tour;
import entity.enums.Role;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class CustomerDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String activationCode;
    private Set<Role> role;
    private String country;
    private String city;
    private String street;
    private Integer numberHouse;
    private Integer numberRoom;
    private String phoneNumber;
    private Date dateOfBirth;
    private String cardNumber;
    private String passportInfo;
    private List<Tour> listOfTours;

    public CustomerDto(){}

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(Integer numberHouse) {
        this.numberHouse = numberHouse;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassportInfo() {
        return passportInfo;
    }

    public void setPassportInfo(String passportInfo) {
        this.passportInfo = passportInfo;
    }

    public List<Tour> getListOfTours() {
        return listOfTours;
    }

    public void setListOfTours(List<Tour> listOfTours) {
        this.listOfTours = listOfTours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getActivationCode(), that.getActivationCode()) &&
                Objects.equals(getRole(), that.getRole()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getStreet(), that.getStreet()) &&
                Objects.equals(getNumberHouse(), that.getNumberHouse()) &&
                Objects.equals(getNumberRoom(), that.getNumberRoom()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getDateOfBirth(), that.getDateOfBirth()) &&
                Objects.equals(getCardNumber(), that.getCardNumber()) &&
                Objects.equals(getPassportInfo(), that.getPassportInfo()) &&
                Objects.equals(getListOfTours(), that.getListOfTours());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmail(), getActivationCode(), getRole(), getCountry(), getCity(), getStreet(), getNumberHouse(), getNumberRoom(), getPhoneNumber(), getDateOfBirth(), getCardNumber(), getPassportInfo(), getListOfTours());
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", role=" + role +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberHouse=" + numberHouse +
                ", numberRoom=" + numberRoom +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cardNumber='" + cardNumber + '\'' +
                ", passportInfo='" + passportInfo + '\'' +
                ", listOfTours=" + listOfTours +
                '}';
    }
}
