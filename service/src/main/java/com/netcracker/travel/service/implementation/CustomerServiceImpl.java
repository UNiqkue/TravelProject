package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dto.*;
import com.netcracker.travel.domain.enumeration.Role;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.NoExistUserException;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.exception.UsernameExistException;
import com.netcracker.travel.repository.*;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.RegistrationService;
import com.netcracker.travel.service.interfaces.SearchTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements AbstractService<CustomerDto>, RegistrationService, SearchTourService {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TravelAgencyRepository travelAgencyRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TravelAgentRepository travelAgentRepository;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private TourConverter tourConverter;
    @Autowired
    private AdminConverter adminConverter;
    @Autowired
    private TravelAgentConverter travelAgentConverter;

    public CustomerServiceImpl() {
    }

    public CustomerDto getByUsername(String username) {
        return customerConverter.convert(customerRepository.findByUsername(username));
    }

    public List<CustomerDto> getAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(customer -> customerConverter.convert(customer))
                .collect(Collectors.toList());
    }

    public CustomerDto updatePhoneNumber(String username, String phoneNumber) {
        CustomerDto customerDto = getByUsername(username);
        customerDto.setPhoneNumber(phoneNumber);
        return customerConverter.convert(customerRepository.save(customerConverter.convert(customerDto)));
    } /**update вместо save**/

    /**
     * viewOrderedTours
     **/
    public List<TourDto> watchTours(UUID id) {
        return tourRepository.findAllByCustomerId(id)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public TourDto buyTour(UUID id, UUID customerId) {
        TourDto tourDto = tourConverter.convert(tourRepository.getById(id.toString().replaceFirst( "([0-9a-fA-F]{8})-([0-9a-fA-F]{4})-([0-9a-fA-F]{4})-([0-9a-fA-F]{4})-([0-9a-fA-F]+)", "$1$2$3$4$5" )));

        if (customerId.equals(tourDto.getCustomerId()) || tourDto.isFree()) {
            tourDto.setCustomerId(customerId);
            tourDto.setFree(false);
            tourDto = tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
            /**update вместо save**/
            System.out.println("You bought tour");
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    public TourDto cancelTour(UUID tourId, UUID userId) {
        TourDto tourDto = tourConverter.convert(tourRepository.getById(tourId.toString()));
        if (userId.equals(tourDto.getCustomerId())) {
            tourDto = tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
            /**updateCancelTrip вместо save**/
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    public List<TourDto> searchTourByName(String name) {
        return tourRepository.findByName(name)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByStartDate(Date startDate) {
        return tourRepository.findByStartDate(startDate)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }
    public List<TourDto> searchTourByEndDate(Date endDate) {
        return tourRepository.findByEndDate(endDate)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByType(String type) {
        return tourRepository.findByType(type)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByCountry(String country) {
        return tourRepository.findByCountry(country)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByTravelAgency(String name) {
        return tourRepository.findByTravelAgencyId(UUID.fromString(travelAgencyRepository.findByName(name).get(0).getId().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5")))
                .stream()
                .map(travel -> tourConverter.convert(travel))
                .collect(Collectors.toList());
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
        return customerConverter.convert(customerRepository.save(customerConverter.convert(customerDto)));
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
            AdminDto adminDto = StreamSupport.stream(adminRepository.findAll().spliterator(), false)
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
            CustomerDto customerDto = StreamSupport.stream(customerRepository.findAll().spliterator(), false)
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
            TravelAgentDto travelAgentDto = StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
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
            TravelAgentDto travelAgentDto = StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
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
            AdminDto adminDto = StreamSupport.stream(adminRepository.findAll().spliterator(), false)
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
            CustomerDto customerDto = StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                    .filter(user -> user.getEmail().equals(email))
                    .map(user -> customerConverter.convert(user))
                    .findFirst().get();
            if (customerDto != null) {
                throw new EmailExistException();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }


}
