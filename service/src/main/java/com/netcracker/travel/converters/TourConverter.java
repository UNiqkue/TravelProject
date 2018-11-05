package com.netcracker.travel.converters;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.TravelAgency;

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

        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setName(tourDto.getNameTravelAgency());
        tour.setTravelAgency(travelAgency);

        Customer customer = new Customer();
        customer.setUsername(tourDto.getUsername());
        tour.setCustomer(customer);

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

        if (tour.getTravelAgency() != null) {
            tourDto.setNameTravelAgency(tour.getTravelAgency().getName());
        }

        if (tour.getCustomer() != null) {
            tourDto.setUsername(tour.getCustomer().getUsername());
        }

        return tourDto;
    }



}
