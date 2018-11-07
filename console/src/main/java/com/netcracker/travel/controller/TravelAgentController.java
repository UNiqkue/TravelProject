package com.netcracker.travel.controller;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;

import java.util.List;
import java.util.UUID;

public class TravelAgentController {

    private TravelAgentServiceImpl travelAgentServiceImpl;

    public TravelAgentDto getTravelAgentById(UUID id) {
        return null;
    }

    public TravelAgentDto getTravelAgentByName(String name) {
        return null;
    }

    public List<TravelAgentDto> getAllTravelAgents() {
        return null;
    }

    public TravelAgentDto save(TravelAgentDto travelAgentDto) {
        return null;
    }

    public void update(TravelAgentDto travelAgentDto) {
    }

    public void delete(UUID id) {
    }

    public void checkExistenceTours(){}
    public void editTour(TourDto tourDto){}
    public void viewOrderHystory(){}

    public TravelAgencyDto getTravelAgencyDto(){return null;}
}
