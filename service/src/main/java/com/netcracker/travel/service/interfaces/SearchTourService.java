package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.TourDto;

import java.sql.Date;
import java.util.List;

public interface SearchTourService {

    List<TourDto> searchTourByName(String name);
    List<TourDto> searchTourByDate(Date startDate, Date endDate);
    List<TourDto> searchTourByType(String type);
    List<TourDto> searchTourByCountry(String country);
    List<TourDto> searchTourByTravelAgency(String name);
}
