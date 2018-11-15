package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        TourDto temp = buyTour(tourDto, customerId);
        System.out.println("You have 3 days to pay for the tour");
        return temp;
    }

    public TourDto buyTour(TourDto tourDto, UUID customerId) {
        tourDto.setCustomerId(customerId);
        tourDto.setFree(false);
        TourDto temp = null;
        try {
            temp = tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void searchTour(){
        // TourDaoImpl getByName, Date, Type, Country
    }

    public TourDto cancelTour(UUID id){
        TourDto temp = null;
        try {
            TourDto tourDto = tourConverter.convert(tourDao.getById(id));
            tourDto.setFree(true);
            temp = tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public List<TourDto> viewOrderedTours(UUID id){
        List<TourDto> tours = null;
        try {
            tours = tourDao.getToursById(id)
                    .stream()
                    .map(tour -> tourConverter.convert(tour))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }


}
