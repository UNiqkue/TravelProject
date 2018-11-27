package com.netcracker.travel.entity;

import com.netcracker.travel.entity.enumeration.Role;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Customer extends User{

    private String phoneNumber;
    private Date dateOfBirth;
    private String cardNumber;
    private String passportInfo;
    private List<Tour> listOfTours;

    public Customer(){}

    public Customer(UUID id, String firstName, String lastName, String username, String password, String email, String activationCode, String phoneNumber, Date dateOfBirth, String cardNumber, String passportInfo) {
        super(id, firstName, lastName, username, password, email, activationCode);
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.passportInfo = passportInfo;
    }

    @Override
    public void setRole(Role role) {
        super.setRole(Role.CUSTOMER);
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

    public List<Tour> getListOfTours() {        return listOfTours;    }

    public void setListOfTours(List<Tour> listOfTours) {
        this.listOfTours = listOfTours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", activationCode='" + getActivationCode() + '\'' +
                ", role=" + getRole() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cardNumber='" + cardNumber + '\'' +
                ", passportInfo='" + passportInfo + '\'' +
                '}';
    }


}