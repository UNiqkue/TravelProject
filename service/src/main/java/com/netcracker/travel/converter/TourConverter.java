package com.netcracker.travel.converter;

import com.netcracker.travel.domain.Tour;
import com.netcracker.travel.dto.TourDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TourConverter {

    public Tour convert(TourDto tourDto) {
        Tour tour = new Tour();
        tour.setId(tourDto.getId().toString());
        tour.setName(tourDto.getName());
        tour.setDescription(tourDto.getDescription());
        tour.setPrice(tourDto.getPrice());
        tour.setType(tourDto.getType());
        tour.setCountry(tourDto.getCountry());
        tour.setStartDate(tourDto.getStartDate());
        tour.setEndDate(tourDto.getEndDate());
        tour.setTravelAgencyId(tourDto.getTravelAgencyId());
        tour.setFree(tourDto.isFree());
        if (tour.isFree() == false) {
            tour.setCustomerId(tourDto.getCustomerId());
        }
        return tour;
    }

    public TourDto convert(Tour tour) {
        TourDto tourDto = new TourDto();
        tourDto.setId(UUID.fromString(tour.getId().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5")));
        tourDto.setName(tour.getName());
        tourDto.setDescription(tour.getDescription());
        tourDto.setPrice(tour.getPrice());
        tourDto.setType(tour.getType().toString());
        tourDto.setCountry(tour.getCountry());
        tourDto.setStartDate(tour.getStartDate());
        tourDto.setEndDate(tour.getEndDate());
        tourDto.setTravelAgencyId(tour.getTravelAgencyId());
        tourDto.setFree(tour.isFree());
        if (tourDto.isFree() == false) {
            tourDto.setCustomerId(tour.getCustomerId());
        }
        return tourDto;
    }


}
