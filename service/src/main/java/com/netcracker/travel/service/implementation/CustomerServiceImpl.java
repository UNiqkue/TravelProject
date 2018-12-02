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
<<<<<<< HEAD
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.exception.UsernameExistException;
=======
import com.netcracker.travel.exception.PhoneNumberException;
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.sql.Date;
import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
=======
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

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
<<<<<<< HEAD
        return customerConverter.convert(customerDao.getByUsername(username));
    }

    public List<CustomerDto> getAll() {
        return customerDao.getAll()
                .stream()
                .map(customer -> customerConverter.convert(customer))
                .collect(Collectors.toList());
    }

    public TourDto bookTour(UUID id, UUID customerId) {
        TourDto temp = buyTour(id, customerId);
        System.out.println("You have 3 days to pay for the tour");
        return temp;
    }

    public TourDto buyTour(UUID id, UUID customerId) {
        TourDto tourDto = tourConverter.convert(tourDao.getById(id));
        tourDto.setCustomerId(customerId);
        tourDto.setFree(false);
        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public List<TourDto> searchTourByName(String name) {
        return tourDao.getByName(name)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByDate(Date startDate, Date endDate) {
        return tourDao.getByDate(startDate, endDate)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByType(String type) {
        return tourDao.getByType(type)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByCountry(String country) {
        return tourDao.getByCountry(country)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByTravelAgency(String name) {
        TravelAgencyDto travelAgencyDto = getTravelAgencyByName(name);
        return tourDao.getByTravelAgencyId(travelAgencyDto.getId())
                .stream()
                .map(travel -> tourConverter.convert(travel))
                .collect(Collectors.toList());
    }

    public TravelAgencyDto getTravelAgencyByName(String name) {
        return travelAgencyConverter.convert(travelAgencyDao.getByName(name)
                .stream()
                .filter(travelAgency -> travelAgency.getName().equals(name))
                .findFirst().get());
=======
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
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
    }


    public TourDto cancelTour(UUID tourId) {
<<<<<<< HEAD
        TourDto tourDto = tourConverter.convert(tourDao.getById(tourId));
        tourDto.setCustomerId(null);
        tourDto.setFree(true);
        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public List<TourDto> viewOrderedTours(UUID id) {
        return tourDao.getToursById(id)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public CustomerDto updatePhoneNumber(String username, String phoneNumber) {
        CustomerDto customerDto = getByUsername(username);
        customerDto.setPhoneNumber(phoneNumber);
        return customerConverter.convert(customerDao.update(customerConverter.convert(customerDto)));
=======
        return null;
    }

    public List<TourDto> viewOrderedTours(UUID id) {
        return null;
    }

    public CustomerDto updatePhoneNumber(String username, String phoneNumber) {
        return null;
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
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
<<<<<<< HEAD
        if (checkExisting(registrationRequestDto) == false) {
            return null;
        }
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(UUID.randomUUID());
        customerDto.setFirstName(registrationRequestDto.getFirstName());
        customerDto.setLastName(registrationRequestDto.getLastName());
        customerDto.setUsername(registrationRequestDto.getUsername());
        customerDto.setEmail(registrationRequestDto.getEmail());
        customerDto.setPassword(registrationRequestDto.getPassword());
        customerDto.setActivationCode(registrationRequestDto.getActivationCode());
        customerDto.setRole(Role.GUEST);
        customerDto.setPassportInfo(registrationRequestDto.getPassportInfo());
        customerDto.setCardNumber(registrationRequestDto.getCardNumber());
        customerDto.setDateOfBirth(registrationRequestDto.getDateOfBirth());
        customerDto.setPhoneNumber(registrationRequestDto.getPhoneNumber());
        return customerConverter.convert(customerDao.save(customerConverter.convert(customerDto)));
    }

    private boolean checkExisting(RegistrationRequestDto registrationRequestDto) {
        try {
            checkUsernameExist(registrationRequestDto.getUsername());
            checkEmailExist(registrationRequestDto.getEmail());
            return true;
        } catch (UsernameExistException e) {
            System.out.println("User with such username exists");
        } catch (EmailExistException e) {
            System.out.println("User with such email exists");
        }
=======
        return null;
    }

    private boolean checkExisting(RegistrationRequestDto registrationRequestDto) {
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
        return false;
    }

    private void checkUsernameExist(String username) {
<<<<<<< HEAD
        try {
            CustomerDto customerDto = customerConverter.convert(customerDao.getByUsername(username));
            if (customerDto != null) {
                throw new UsernameExistException();
            }
        } catch (NoSuchElementException e) {
        }
    }

    private void checkEmailExist(String email) {
        try {
            CustomerDto customerDto = customerConverter.convert(customerDao.getByEmail(email));
            if (customerDto != null) {
                throw new EmailExistException();
            }
        } catch (NoSuchElementException e) {
        }
=======

    }

    private void checkEmailExist(String email) {

>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
    }


}
