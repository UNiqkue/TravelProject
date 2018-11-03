package entity;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Customer extends User{

    private String phoneNumber;
    private Date dateOfBirth;
    private String address;
    private String cardNumber;
    private String passportInfo;
    private List<Tour> listOfTours;

    public Customer(){}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return Objects.equals(getPhoneNumber(), customer.getPhoneNumber()) &&
                Objects.equals(getDateOfBirth(), customer.getDateOfBirth()) &&
                Objects.equals(getAddress(), customer.getAddress()) &&
                Objects.equals(getCardNumber(), customer.getCardNumber()) &&
                Objects.equals(getPassportInfo(), customer.getPassportInfo()) &&
                Objects.equals(getListOfTours(), customer.getListOfTours());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPhoneNumber(), getDateOfBirth(), getAddress(), getCardNumber(), getPassportInfo(), getListOfTours());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", passportInfo='" + passportInfo + '\'' +
                ", listOfTours=" + listOfTours +
                '}';
    }
}