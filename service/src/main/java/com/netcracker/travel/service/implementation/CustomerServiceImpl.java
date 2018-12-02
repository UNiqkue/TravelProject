package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
<<<<<<< HEAD
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.*;
import com.netcracker.travel.dto.*;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.NoExistUserException;
=======
import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.EmailExistException;
>>>>>>> task3
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.exception.UsernameExistException;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.RegistrationService;
<<<<<<< HEAD
import com.netcracker.travel.service.interfaces.SearchTourService;
=======
>>>>>>> task3

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

<<<<<<< HEAD
public class CustomerServiceImpl implements AbstractService<CustomerDto>, RegistrationService, SearchTourService {
=======
public class CustomerServiceImpl implements AbstractService<CustomerDto>, RegistrationService {
>>>>>>> task3

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();
<<<<<<< HEAD
    private AdminDaoImpl adminDao = AdminDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private CustomerConverter customerConverter = new CustomerConverter();
    private TourConverter tourConverter = new TourConverter();
    private AdminConverter adminConverter = new AdminConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();

    public CustomerServiceImpl() {
    }

    public CustomerDto getByUsername(String username) {
        return customerConverter.convert(customerDao.getByUsername(username));
    }

    public List<CustomerDto> getAll() {
        return customerDao.getAll()
                .stream()
                .map(customer -> customerConverter.convert(customer))
                .collect(Collectors.toList());
    }

    public CustomerDto updatePhoneNumber(String username, String phoneNumber) {
        CustomerDto customerDto = getByUsername(username);
        customerDto.setPhoneNumber(phoneNumber);
        return customerConverter.convert(customerDao.update(customerConverter.convert(customerDto)));
    }

    /**
     * viewOrderedTours
     **/
    public List<TourDto> watchTours(UUID id) {
        return tourDao.getToursById(id)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public TourDto buyTour(UUID id, UUID customerId) {
        TourDto temp = buyTour(id, customerId);
        System.out.println("You bought this tour");
        return temp;
    }

    public TourDto bookTour(UUID id, UUID customerId) {
        TourDto tourDto = tourConverter.convert(tourDao.getById(id));
        if (customerId.equals(tourDto.getCustomerId()) || tourDto.isFree()) {
            tourDto.setCustomerId(customerId);
            tourDto.setFree(false);
            tourDto = tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
            System.out.println("You booked tour");
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    public TourDto cancelTour(UUID tourId, UUID userId) {
        TourDto tourDto = tourConverter.convert(tourDao.getById(tourId));
        if (userId.equals(tourDto.getCustomerId())) {
            tourDto = tourConverter.convert(tourDao.updateCancelTrip(tourConverter.convert(tourDto)));
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
=======

    private CustomerConverter customerConverter = new CustomerConverter();
    private TourConverter tourConverter = new TourConverter();
    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();

    public CustomerServiceImpl() {
    }

    public CustomerDto getByUsername(String username) {
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
>>>>>>> task3
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
<<<<<<< HEAD
        return tourDao.getByTravelAgencyId(travelAgencyDao.getByName(name).get(0).getId())
=======
        TravelAgencyDto travelAgencyDto = getTravelAgencyByName(name);
        return tourDao.getByTravelAgencyId(travelAgencyDto.getId())
>>>>>>> task3
                .stream()
                .map(travel -> tourConverter.convert(travel))
                .collect(Collectors.toList());
    }

<<<<<<< HEAD
=======
    public TravelAgencyDto getTravelAgencyByName(String name) {
        return travelAgencyConverter.convert(travelAgencyDao.getByName(name)
                .stream()
                .filter(travelAgency -> travelAgency.getName().equals(name))
                .findFirst().get());
    }


    public TourDto cancelTour(UUID tourId) {
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
    }

>>>>>>> task3
    public void verifyPhoneNumber(String phoneNumber) throws PhoneNumberException {
        Pattern pattern = Pattern.compile("((80|\\+375)[\\s|-]?(29|25|33|44))[\\s|-]?(\\d{7}|\\d{3}[\\s|-]?\\d{2}[\\s|-]?\\d{2})");
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean bl = matcher.matches();
        System.out.println(bl);
        if (!bl) {
            throw new PhoneNumberException("Invalid phone number");
<<<<<<< HEAD
        }
    }

    public CustomerDto registration(RegistrationRequestDto registrationRequestDto) {
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
        } catch (NoExistUserException e) {
            System.out.println("You can't register (invalid username, email or other user data)");
        }
        return false;
    }

    private void checkUsernameExist(String username) {
        checkCustomerUsername(username);
        checkAdminUsername(username);
        checkTravelAgentUsername(username);
    }

    private void checkAdminUsername(String username) {
        try {
            AdminDto adminDto = adminDao.getAll()
                    .stream()
                    .filter(user -> user.getUsername().equals(username))
                    .map(user -> adminConverter.convert(user))
                    .findFirst().get();
            if (adminDto != null) {
                throw new UsernameExistException();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkCustomerUsername(String username) {
        try {
            CustomerDto customerDto = customerDao.getAll()
                    .stream()
                    .filter(user -> user.getUsername().equals(username))
                    .map(user -> customerConverter.convert(user))
                    .findFirst().get();
            if (customerDto != null) {
                throw new UsernameExistException();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }


    private void checkTravelAgentUsername(String username) {
        try {
            TravelAgentDto travelAgentDto = travelAgentDao.getAll()
                    .stream()
                    .filter(user -> user.getUsername().equals(username))
                    .map(user -> travelAgentConverter.convert(user))
                    .findFirst().get();
            if (travelAgentDto != null) {
                throw new UsernameExistException();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkEmailExist(String email) {
        checkCustomerEmail(email);
        checkAdminEmail(email);
        checkTravelAgentEmail(email);
    }

    private void checkTravelAgentEmail(String email) {
        try {
            TravelAgentDto travelAgentDto = travelAgentDao.getAll()
                    .stream()
                    .filter(user -> user.getEmail().equals(email))
                    .map(user -> travelAgentConverter.convert(user))
                    .findFirst().get();
            if (travelAgentDto != null) {
                throw new EmailExistException();
            }
        } catch (NoSuchElementException e) {
            System.out.println("You registered");
        }
    }

    private void checkAdminEmail(String email) {
        try {
            AdminDto adminDto = adminDao.getAll()
                    .stream()
                    .filter(user -> user.getEmail().equals(email))
                    .map(user -> adminConverter.convert(user))
                    .findFirst().get();
            if (adminDto != null) {
                throw new EmailExistException();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkCustomerEmail(String email) {
        try {
            CustomerDto customerDto = customerDao.getAll()
                    .stream()
                    .filter(user -> user.getEmail().equals(email))
                    .map(user -> customerConverter.convert(user))
                    .findFirst().get();
=======
        }
    }

    public CustomerDto registration(RegistrationRequestDto registrationRequestDto) {
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
        return false;
    }

    private void checkUsernameExist(String username) {
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
>>>>>>> task3
            if (customerDto != null) {
                throw new EmailExistException();
            }
        } catch (NoSuchElementException e) {
<<<<<<< HEAD
            System.out.println("Checking");
=======
>>>>>>> task3
        }
    }


}
