package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements AbstractService<CustomerDto>, AuthenticationService {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();

    private CustomerConverter customerConverter = new CustomerConverter();
    private TourConverter tourConverter = new TourConverter();

    public CustomerServiceImpl(){

    }

    public List<CustomerDto> getAll(){
        return null;
    }

    public TourDto bookTour(TourDto tourDto, UUID customerId) {
        return null;
    }

    public TourDto buyTour(TourDto tourDto, UUID customerId) {
        return null;
    }

    public void searchTourByName(){

    }

    public void searchTourByDate(){

    }

    public void searchTourByType(){

    }

    public void searchTourByCountry(){

    }

    public TourDto cancelTour(UUID id){
        return null;
    }

    public List<TourDto> viewOrderedTours(UUID id){
        return new ArrayList<>();
    }

    public boolean login(LoginRequestDto loginRequestDto) {
        return false;
    }

}
