package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerServiceImpl implements AbstractService<CustomerDto>, RegistrationService {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();

    private CustomerConverter customerConverter = new CustomerConverter();
    private TourConverter tourConverter = new TourConverter();
    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();

    public CustomerServiceImpl() {
    }

    public CustomerDto getByUsername(String username) {
        return null;
    }

    public List<CustomerDto> getAll() {
        return null;
    }

    public TourDto bookTour(UUID id, UUID customerId) {
        return null;
    }

    public TourDto buyTour(UUID id, UUID customerId) {
        return null;
    }

    public List<TourDto> searchTourByName(String name) {
        return null;
    }

    public List<TourDto> searchTourByDate(Date startDate, Date endDate) {
        return null;
    }

    public List<TourDto> searchTourByType(String type) {
        return null;
    }

    public List<TourDto> searchTourByCountry(String country) {
        return null;
    }

    public List<TourDto> searchTourByTravelAgency(String name) {

        return null;
    }

    public TravelAgencyDto getTravelAgencyByName(String name) {
        return null;
    }


    public TourDto cancelTour(UUID tourId) {
        return null;
    }

    public List<TourDto> viewOrderedTours(UUID id) {
        return null;
    }

    public CustomerDto updatePhoneNumber(String username, String phoneNumber) {
        return null;
    }

    public void verifyPhoneNumber(String phoneNumber) throws PhoneNumberException {
        Pattern pattern = Pattern.compile("((80|\\+375)[\\s|-]?(29|25|33|44))[\\s|-]?(\\d{7}|\\d{3}[\\s|-]?\\d{2}[\\s|-]?\\d{2})");
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean bl = matcher.matches();
        System.out.println(bl);
        if (!bl) {
            throw new PhoneNumberException("Invalid phone number");
        }
    }

    public CustomerDto registration(RegistrationRequestDto registrationRequestDto) {
        return null;
    }

    private boolean checkExisting(RegistrationRequestDto registrationRequestDto) {
        return false;
    }

    private void checkUsernameExist(String username) {

    }

    private void checkEmailExist(String email) {

    }


}
