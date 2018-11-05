package com.netcracker.travel.converters;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.entity.Address;
import com.netcracker.travel.entity.Customer;

public class CustomerConverter {

    public Customer convert(CustomerDto customerDto){
        Customer customer= new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setEmail(customerDto.getEmail());
        customer.setActivationCode(customerDto.getActivationCode());

        Address address = new Address();
        address.setCountry(customerDto.getCountry());
        address.setCity(customerDto.getCity());
        address.setStreet(customerDto.getStreet());
        address.setNumberHouse(customerDto.getNumberHouse());
        address.setNumberRoom(customerDto.getNumberRoom());
        customer.setAddress(address);

        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setCardNumber(customerDto.getCardNumber());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setPassportInfo(customerDto.getPassportInfo());
        customer.setListOfTours(customerDto.getListOfTours());
        return customer;
    }

    public CustomerDto convert(Customer customer){
        CustomerDto customerDto= new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUsername(customer.getUsername());
        customerDto.setPassword(customer.getPassword());
        customerDto.setEmail(customer.getEmail());
        customerDto.setActivationCode(customer.getActivationCode());

        if (customer.getAddress() != null) {
            customerDto.setCountry(customer.getAddress().getCountry());
            customerDto.setCity(customer.getAddress().getCity());
            customerDto.setStreet(customer.getAddress().getStreet());
            customerDto.setNumberHouse(customer.getAddress().getNumberHouse());
            customerDto.setNumberRoom(customer.getAddress().getNumberRoom());
        }

        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCardNumber(customer.getCardNumber());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setPassportInfo(customer.getPassportInfo());
        customerDto.setListOfTours(customer.getListOfTours());

        return customerDto;
    }
}
