package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto>, AuthenticationService {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();
    private TourConverter tourConverter = new TourConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();

    public TravelAgentServiceImpl(){}

    public List<TravelAgentDto> getAll() {
        return null;
    }

    public TourDto createTour(TourDto tourDto) {
        return null;
    }

    public List<TourDto> checkExistenceTours(){
        return new ArrayList<>();
    }

    public TourDto editTour(TourDto tourDto) {
        return null;
    }

    public List<TourDto> viewOrderHystory(UUID clientId) {
        return new ArrayList<>();

    }

    public boolean login(LoginRequestDto loginRequestDto) {
        return false;
    }

    public TravelAgencyDto getTravelAgency(UUID id){
        return null;
    }

}
