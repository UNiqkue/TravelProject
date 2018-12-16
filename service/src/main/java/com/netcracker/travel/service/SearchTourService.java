package com.netcracker.travel.service;

import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.entity.enumeration.TypeTour;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface SearchTourService<T> {

    List<T> searchTourByName(String name);

    List<T> searchTourByStartDate(Date startDate);

    List<T> searchTourByEndDate(Date endDate);

    List<T> searchTourByType(TypeTour type);

    List<T> searchTourByCountry(String country);

    List<T> searchTourByTravelAgency(String name);

    T buyTour(String id, CustomerDTO customerDTO);

    T cancelTour(String tourId, String customerId);

    List<T> watchCustomerTours(CustomerDTO customerDTO);

}
