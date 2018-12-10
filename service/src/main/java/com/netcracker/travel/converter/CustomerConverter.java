package com.netcracker.travel.converter;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerConverter {

    public Customer convert(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId().toString());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setEmail(customerDto.getEmail());
        customer.setActivationCode(customerDto.getActivationCode());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setCardNumber(customerDto.getCardNumber());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setPassportInfo(customerDto.getPassportInfo());
        return customer;
    }

    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(UUID.fromString(customer.getId().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5")));
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUsername(customer.getUsername());
        customerDto.setPassword(customer.getPassword());
        customerDto.setEmail(customer.getEmail());
        customerDto.setActivationCode(customer.getActivationCode());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCardNumber(customer.getCardNumber());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setPassportInfo(customer.getPassportInfo());
        return customerDto;
    }

}
