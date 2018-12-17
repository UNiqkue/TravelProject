package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminMapper;
import com.netcracker.travel.converter.CustomerMapper;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.RegistrationRequestDTO;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.NoExistUserException;
import com.netcracker.travel.exception.UsernameExistException;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
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

    private final CustomerRepository customerRepository;

    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    private AdminMapper adminMapper = Mappers.getMapper(AdminMapper.class);

    @Autowired
    public RegistrationServiceImpl(AdminRepository adminRepository, CustomerRepository customerRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
    }

    public CustomerDTO registration(RegistrationRequestDTO registrationRequestDto) {
        log.info("RegistrationServiceImpl registration customer");
        if (checkExisting(registrationRequestDto)) {
            CustomerDTO customerDto = new CustomerDTO();
            BeanUtils.copyProperties(registrationRequestDto, customerDto);
            customerDto.setId(UUID.randomUUID().toString());
            customerDto.setRole(Role.CUSTOMER);
            return customerMapper.customerToCustomerDTO(customerRepository.save(customerMapper.customerDTOtoCustomer(customerDto)));
        } else {
            return null;
        }
    }

    private boolean checkExisting(RegistrationRequestDTO registrationRequestDto) {
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
        try {
            StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                    .filter(user -> user.getUsername().equals(username))
                    .map(adminMapper::adminToAdminDTO)
                    .findFirst().get();
            throw new UsernameExistException();
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

    private void checkEmailExist(String email) {
        try {
            StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                    .filter(user -> user.getEmail().equals(email))
                    .map(adminMapper::adminToAdminDTO)
                    .findFirst().get();
            throw new EmailExistException();
        } catch (NoSuchElementException e) {
            System.out.println("Checking");
        }
    }

}
