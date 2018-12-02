package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.Tour;

public class TourConverter {

<<<<<<< HEAD
    public Tour convert(TourDto tourDto) {
        Tour tour = new Tour();
=======
    public Tour convert(TourDto tourDto){
        Tour tour= new Tour();
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

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
<<<<<<< HEAD
        if (tour.isFree() == false) {
=======
        if(tour.isFree() == false) {
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
            tour.setCustomerId(tourDto.getCustomerId());
        }


        return tour;
    }

<<<<<<< HEAD
    public TourDto convert(Tour tour) {
        TourDto tourDto = new TourDto();
=======
    public TourDto convert(Tour tour){
        TourDto tourDto= new TourDto();
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

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
<<<<<<< HEAD
        if (tourDto.isFree() == false) {
=======
        if(tourDto.isFree() == false) {
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
            tourDto.setCustomerId(tour.getCustomerId());
        }

        return tourDto;
    }


<<<<<<< HEAD
=======

>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
}
