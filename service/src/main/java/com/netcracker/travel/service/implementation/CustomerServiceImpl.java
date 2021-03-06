package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerMapper;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Transactional
@Service
public class CustomerServiceImpl implements BaseService<CustomerDTO> {

    private final CustomerRepository customerRepository;

    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAll() {
        log.info("CustomerServiceImpl findAll");
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getById(String id) {
        log.info("CustomerServiceImpl getById user with id: {} ", id);
        return customerMapper.customerToCustomerDTO(customerRepository.findOne(id));
    }

    public CustomerDTO save(CustomerDTO customerDto) {
        log.info("CustomerServiceImpl save user: {}", customerDto.toString());
        customerDto.setId(UUID.randomUUID().toString());
        customerDto.setRole(Role.CUSTOMER);
        return customerMapper.customerToCustomerDTO(customerRepository.save(customerMapper.customerDTOtoCustomer(customerDto)));
    }

    public CustomerDTO update(String id, CustomerDTO customerDto) {
        log.info("CustomerServiceImpl update user: {}", customerDto.toString());
        customerDto.setId(id);
        return customerMapper.customerToCustomerDTO(customerRepository.save(customerMapper.customerDTOtoCustomer(customerDto)));
    }

    public void delete(String id) {
        log.info("CustomerServiceImpl delete user with id: {} ", id);
        customerRepository.delete(id);
    }

    public void verifyPhoneNumber(String phoneNumber) throws PhoneNumberException {
        String regPhoneNumber = "((80|\\+375)[\\s|-]?(29|25|33|44))[\\s|-]?(\\d{7}|\\d{3}[\\s|-]?\\d{2}[\\s|-]?\\d{2})";
        Pattern pattern = Pattern.compile(regPhoneNumber);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean bl = matcher.matches();
        System.out.println(bl);
        if (!bl) {
            throw new PhoneNumberException("Invalid phone number");
        }
    }


}
