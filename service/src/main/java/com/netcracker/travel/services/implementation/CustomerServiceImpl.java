package com.netcracker.travel.services.implementation;

import com.netcracker.travel.daos.implementation.CustomerDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.services.interfaces.AbstractService;
import com.netcracker.travel.services.interfaces.AuthenticationService;

import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl<CustomerDto, Customer> implements AbstractService<CustomerDto>, AuthenticationService {

    private CustomerDaoImpl<Customer> customerDaoImpl;

    public CustomerServiceImpl(){
        customerDaoImpl = CustomerDaoImpl.getInstance();
    }

    public CustomerDto getById(UUID id) {
        return null;
    }

    public CustomerDto getByName(String name) {
        CustomerDaoImpl.getInstance();
        customerDaoImpl.getByName("Lucas");
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

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    public List<TourDto> getTours(){return null;}
}
