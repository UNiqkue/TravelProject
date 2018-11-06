package com.netcracker.travel.controllers;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.services.implementation.CustomerServiceImpl;

import java.util.List;
import java.util.UUID;

public class CustomerController {

    private CustomerServiceImpl<CustomerDto, Customer> customerServiceImpl;

    public CustomerDto getById(UUID id) {
        return null;
    }

    public CustomerDto getByName(String name) {
        return null;
    }

    public List<CustomerDto> getAll() {
        return null;
    }

    public CustomerDto save(CustomerDto customerDto) {
        return null;
    }

    public void update(CustomerDto customerDto) {
    }

    public void delete(UUID id) {
    }

    public void bookTour(){}

    public void buyTour(){

    }

    public void searchTour(){}

    public void cancelTour(){}

    public void viewOrderedTours(){}

    public List<TourDto> getTours(){return null;}

}
