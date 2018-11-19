package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.Tour;

public class TourConverter {

    public Tour convert(TourDto tourDto){
        Tour tour= new Tour();
        return tour;
    }

    public TourDto convert(Tour tour){
        TourDto tourDto= new TourDto();
        return tourDto;
    }



}
