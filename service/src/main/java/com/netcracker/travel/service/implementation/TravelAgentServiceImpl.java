package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.interfaces.AbstractService;

import java.util.List;
import java.util.UUID;

public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto> {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();
    private TourConverter tourConverter = new TourConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();

    public TravelAgentServiceImpl() {
    }

    public TourDto createTour(TourDto tourDto) {
        return null;
    }

    public List<TourDto> checkExistenceTours() {
        return null;
    }

    public TourDto editTour(UUID id, String description) {
        return null;
    }

    public List<TourDto> viewOrderHystory() {
        return null;
    }

    public TravelAgencyDto getTravelAgency(UUID id) {
        return null;
    }

    public TravelAgentDto getByUsername(String username) {
        return null;
    }

    public List<TravelAgentDto> getAll() {
        return null;
    }

    public TourDto makeDiscount(UUID id, Double price) {
        return null;
    }

    public void deleteTour(UUID id) {

    }
}
