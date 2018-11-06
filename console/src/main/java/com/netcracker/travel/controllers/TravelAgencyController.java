package com.netcracker.travel.controllers;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.services.implementation.TravelAgencyServiceImpl;

import java.util.List;
import java.util.UUID;

public class TravelAgencyController {

    private TravelAgencyServiceImpl<TravelAgencyDto, TravelAgency> travelAgencyServiceImpl;

    public TravelAgencyDto getTravelAgencyById(UUID id) {
        return null;
    }

    public TravelAgencyDto getTravelAgencyByName(String name) {
        return null;
    }

    public List<TravelAgencyDto> getAllTravelAgencies() {
        return null;
    }

    public TravelAgencyDto save(TravelAgencyDto travelAgencyDto) {
        return null;
    }

    public void update(TravelAgencyDto travelAgencyDto) {
    }

    public void delete(UUID id) {
    }

    public List<TourDto> getListTours(){ return null;}
}
