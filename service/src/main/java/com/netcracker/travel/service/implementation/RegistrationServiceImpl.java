package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.domain.enumeration.Role;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.NoExistUserException;
import com.netcracker.travel.exception.UsernameExistException;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.repository.TravelAgentRepository;
import com.netcracker.travel.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Slf4j
@Transactional
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final AdminRepository adminRepository;

    private final TravelAgentRepository travelAgentRepository;

    private final AdminConverter adminConverter;

    private final TravelAgentConverter travelAgentConverter;

    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter;

    @Autowired
    public RegistrationServiceImpl(AdminRepository adminRepository, TravelAgentRepository travelAgentRepository, AdminConverter adminConverter, TravelAgentConverter travelAgentConverter, CustomerRepository customerRepository, CustomerConverter customerConverter) {
        this.adminRepository = adminRepository;
        this.travelAgentRepository = travelAgentRepository;
        this.adminConverter = adminConverter;
        this.travelAgentConverter = travelAgentConverter;
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    public CustomerDto registration(RegistrationRequestDto registrationRequestDto) {
        log.info("RegistrationServiceImpl registration customer");
        if (checkExisting(registrationRequestDto)) {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(registrationRequestDto, customerDto);
            customerDto.setId(UUID.randomUUID().toString());
            customerDto.setRole(Role.GUEST);
            return customerConverter.convert(customerRepository.save(customerConverter.convert(customerDto)));
        } else {
            return null;
        }
    }

    private boolean checkExisting(RegistrationRequestDto registrationRequestDto) {
        try {
            checkUsernameExist(registrationRequestDto.getUsername());
            checkEmailExist(registrationRequestDto.getEmail());
            return true;
        } catch (UsernameExistException e) {
            log.info("User with such username exists");
        } catch (EmailExistException e) {
            log.info("User with such email exists");
        } catch (NoExistUserException e) {
            log.info("You can't register (invalid username, email or other user data)");
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
            StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                    .filter(user -> user.getUsername().equals(username))
                    .map(adminConverter::convert)
                    .findFirst().get();
            throw new UsernameExistException();
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkCustomerUsername(String username) {
        try {
            StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                    .filter(user -> user.getUsername().equals(username))
                    .map(customerConverter::convert)
                    .findFirst().get();
            throw new UsernameExistException();
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkTravelAgentUsername(String username) {
        try {
            StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
                    .filter(user -> user.getUsername().equals(username))
                    .map(travelAgentConverter::convert)
                    .findFirst().get();
            throw new UsernameExistException();
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
            StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
                    .filter(user -> user.getEmail().equals(email))
                    .map(travelAgentConverter::convert)
                    .findFirst().get();
            throw new EmailExistException();
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkAdminEmail(String email) {
        try {
            StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                    .filter(user -> user.getEmail().equals(email))
                    .map(adminConverter::convert)
                    .findFirst().get();
            throw new EmailExistException();
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkCustomerEmail(String email) {
        try {
            StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                    .filter(user -> user.getEmail().equals(email))
                    .map(customerConverter::convert)
                    .findFirst().get();
            throw new EmailExistException();
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }
}
