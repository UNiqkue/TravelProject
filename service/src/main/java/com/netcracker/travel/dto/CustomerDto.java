package com.netcracker.travel.dto;

import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.Role;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CustomerDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String activationCode;
    private Role role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
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
