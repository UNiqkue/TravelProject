package com.netcracker.travel.converter;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.entity.Customer;

public class CustomerConverter {

    public Customer convert(CustomerDto customerDto) {
        Customer customer = new Customer();
        return customer;
    }

    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        return customerDto;
    }
}
