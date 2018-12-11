package com.netcracker.travel.converter;

import com.netcracker.travel.domain.Tour;
import com.netcracker.travel.dto.TourDto;
import org.springframework.stereotype.Component;

@Component
public class TourConverter {

    public Tour convert(TourDto tourDto) {
        Tour tour = new Tour();
        tour.setId(tourDto.getId());
        tour.setName(tourDto.getName());
        tour.setDescription(tourDto.getDescription());
        tour.setPrice(tourDto.getPrice());
        tour.setType(tourDto.getType());
        tour.setCountry(tourDto.getCountry());
        tour.setStartDate(tourDto.getStartDate());
        tour.setEndDate(tourDto.getEndDate());
     //   tour.setTravelAgency(tourDto.getTravelAgency());
        tour.setFree(tourDto.isFree());
        if (!tour.isFree()) {
          //  tour.setCustomer(tourDto.getCustomer());
        }
        return tour;
    }

    public TourDto convert(Tour tour) {
        TourDto tourDto = new TourDto();
        tourDto.setId(tour.getId());
        tourDto.setName(tour.getName());
        tourDto.setDescription(tour.getDescription());
        tourDto.setPrice(tour.getPrice());
        tourDto.setType(tour.getType().toString());
        tourDto.setCountry(tour.getCountry());
        tourDto.setStartDate(tour.getStartDate());
        tourDto.setEndDate(tour.getEndDate());
     //   tourDto.setTravelAgency(tour.getTravelAgency());
        tourDto.setFree(tour.isFree());
        if (!tourDto.isFree()) {
          //  tourDto.setCustomer(tour.getCustomer());
        }
        return tourDto;
    }


}
