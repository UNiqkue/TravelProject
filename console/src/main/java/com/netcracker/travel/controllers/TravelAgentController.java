package com.netcracker.travel.controllers;

import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.entity.TravelAgent;
import com.netcracker.travel.services.implementation.TravelAgentServiceImpl;

import java.util.List;
import java.util.UUID;

public class TravelAgentController {

    private TravelAgentServiceImpl travelAgentServiceImpl;

    public TravelAgent getTravelAgentById(UUID id) {
        return null;
    }

    public TravelAgent getTravelAgentByName(String name) {
        return null;
    }

    public List<TravelAgent> getAllTravelAgents() {
        return null;
    }

    public TravelAgent save(TravelAgent travelAgent) {
        return null;
    }

    public void update(TravelAgent travelAgent) {
    }

    public void delete(UUID id) {
    }

    public void checkExistenceTours(){}
    public void editTour(Tour tour){}
    public void viewOrderHystory(){}

    public TravelAgency getTravelAgency(){return null;}
}
