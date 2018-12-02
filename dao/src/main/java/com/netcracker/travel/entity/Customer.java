package com.netcracker.travel.entity;

import com.netcracker.travel.entity.enumeration.Role;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

<<<<<<< HEAD
public class Customer extends User {
=======
public class Customer extends User{
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

    private String phoneNumber;
    private Date dateOfBirth;
    private String cardNumber;
    private String passportInfo;
    private List<Tour> listOfTours;

<<<<<<< HEAD
    public Customer() {
    }
=======
    public Customer(){}
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

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

<<<<<<< HEAD
    public List<Tour> getListOfTours() {
        return listOfTours;
    }
=======
    public List<Tour> getListOfTours() {        return listOfTours;    }
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

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
