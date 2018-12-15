package com.netcracker.travel.converter;

import com.netcracker.travel.domain.Customer;
import com.netcracker.travel.dto.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer convert(CustomerDTO customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
     /*   customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setEmail(customerDto.getEmail());
        customer.setActivationCode(customerDto.getActivationCode());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setCardNumber(customerDto.getCardNumber());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setPassportInfo(customerDto.getPassportInfo());*/
        return customer;
    }

    public CustomerDTO convert(Customer customer) {
        CustomerDTO customerDto = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDto);
      /*  customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUsername(customer.getUsername());
        customerDto.setPassword(customer.getPassword());
        customerDto.setEmail(customer.getEmail());
        customerDto.setActivationCode(customer.getActivationCode());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCardNumber(customer.getCardNumber());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setPassportInfo(customer.getPassportInfo());*/
        return customerDto;
    }

}
