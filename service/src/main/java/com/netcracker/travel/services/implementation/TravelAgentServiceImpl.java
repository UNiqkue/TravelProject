package com.netcracker.travel.services.implementation;

import com.netcracker.travel.daos.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.*;
import com.netcracker.travel.entity.TravelAgent;
import com.netcracker.travel.services.interfaces.AbstractService;
import com.netcracker.travel.services.interfaces.AuthenticationService;

import java.util.List;
import java.util.UUID;

public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto>, AuthenticationService {

    private TravelAgentDaoImpl<TravelAgent> travelAgentDaoImpl;

    public TravelAgentServiceImpl(){
        travelAgentDaoImpl = TravelAgentDaoImpl.getInstance();
    }

    public TravelAgentDto getById(UUID id) {
        return null;
    }

    public TravelAgentDto getByName(String name) {
        return null;
    }

    public List<TravelAgentDto> getAll() {
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

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    public TravelAgencyDto getTravelAgency(){return null;}
}
