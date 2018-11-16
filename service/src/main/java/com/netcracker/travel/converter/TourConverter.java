package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.Tour;


public class TourConverter {

    public Tour convert(TourDto tourDto){
        Tour tour= new Tour();

        tour.setId(tourDto.getId());
        tour.setName(tourDto.getName());
        tour.setDescription(tourDto.getDescription());
        tour.setPrice(tourDto.getPrice());
        tour.setType(tourDto.getType());
        tour.setCountry(tourDto.getCountry());
        tour.setStartDate(tourDto.getStartDate());
        tour.setEndDate(tourDto.getEndDate());
        tour.setTravelAgencyId(tourDto.getTravelAgencyId());
        tour.setFree(tourDto.isFree());
        if(tour.isFree() == false) {
            tour.setCustomerId(tourDto.getCustomerId());
        }


        return tour;
    }

    public TourDto convert(Tour tour){
        TourDto tourDto= new TourDto();

        tourDto.setId(tour.getId());
        tourDto.setName(tour.getName());
        tourDto.setDescription(tour.getDescription());
        tourDto.setPrice(tour.getPrice());
        tourDto.setType(tour.getType());
        tourDto.setCountry(tour.getCountry());
        tourDto.setStartDate(tour.getStartDate());
        tourDto.setEndDate(tour.getEndDate());
        tourDto.setTravelAgencyId(tour.getTravelAgencyId());
        tourDto.setFree(tour.isFree());
        if(tourDto.isFree() == false) {
            tourDto.setCustomerId(tour.getCustomerId());
        }

        return tourDto;
    }



}
