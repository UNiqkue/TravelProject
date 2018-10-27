package dao.entity;

import java.sql.Date;
import java.util.List;

public class Customer extends User{

    private String phoneNumber;
    private Date dateOfBirth;
    private String address;
    private long cardNumber;
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

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
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

}
