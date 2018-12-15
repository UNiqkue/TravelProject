package com.netcracker.travel.service;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface SearchTourService<T> {

    List<T> searchTourByName(String name);

    List<T> searchTourByStartDate(Date startDate);

    List<T> searchTourByEndDate(Date endDate);

    List<T> searchTourByType(String type);

    List<T> searchTourByCountry(String country);

    List<T> searchTourByTravelAgency(String name);

    T buyTour(UUID id, UUID customerId);

    T cancelTour(UUID tourId, UUID customerId);

}
