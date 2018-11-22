package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.service.interfaces.AbstractService;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements AbstractService<CustomerDto> {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();

    private CustomerConverter customerConverter = new CustomerConverter();
    private TourConverter tourConverter = new TourConverter();

    public CustomerServiceImpl(){
    }

    public CustomerDto getByUsername(String username) {
        return customerConverter.convert(customerDao.getByUsername(username));
    }

    public List<CustomerDto> getAll(){
        return customerDao.getAll()
                .stream()
                .map(customer -> customerConverter.convert(customer))
                .collect(Collectors.toList());
    }

    public TourDto bookTour(TourDto tourDto, UUID customerId) {
        TourDto temp = buyTour(tourDto, customerId);
        System.out.println("You have 3 days to pay for the tour");
        return temp;
    }

    public TourDto buyTour(TourDto tourDto, UUID customerId) {
        tourDto.setCustomerId(customerId);
        tourDto.setFree(false);
        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public void searchTourByName(String name){
        // TourDaoImpl getByName, Date, Type, Country
    }
    public void searchTourByDate(Date startDate, Date endDate){
        // TourDaoImpl getByName, Date, Type, Country
    }
    public void searchTourByType(int x){
        // TourDaoImpl getByName, Date, Type, Country
    }
    public void searchTourByCountry(String country){
        // TourDaoImpl getByName, Date, Type, Country
    }

    public TourDto cancelTour(UUID id){
        TourDto tourDto = tourConverter.convert(tourDao.getById(id));
        tourDto.setFree(true);
        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public List<TourDto> viewOrderedTours(UUID id){
        return tourDao.getToursById(id)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public CustomerDto updatePhoneNumber(String username, String phoneNumber) {
        CustomerDto customerDto = getByUsername(username);
        customerDto.setPhoneNumber(phoneNumber);
        return customerConverter.convert(customerDao.update(customerConverter.convert(customerDto)));
    }

    public static void main(String[] args){
        CustomerServiceImpl customerService = new CustomerServiceImpl();
//        customerService.updatePhoneNumber("kili1", "+375-44-234-57-13");
       // CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();
       // System.out.println(customerDao.getByUsername("ukky3"));
        System.out.println(customerService.getByUsername("ukky3"));
    }
}
