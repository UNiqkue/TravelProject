package com.netcracker.travel.controllers;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.services.implementation.TourServiceImpl;

import java.util.List;
import java.util.UUID;

public class TourController {

    private TourServiceImpl tourServiceImpl = new TourServiceImpl();

    public TourDto getTourById(UUID id) {
        return null;
    }

    public TourDto getTourByName(String name) {
        return null;
    }

    public List<TourDto> getAllTours() {
        return tourServiceImpl.getAll();
    }

    public TourDto save(TourDto tourDto) {
        return null;
    }

    public void update(TourDto tourDto) {
    }

    public void delete(UUID id) {
    }

    public CustomerDto getCustomer(){return null;}
}
