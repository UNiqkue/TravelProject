package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.*;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto>, AuthenticationService {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();
    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();
    private TourConverter tourConverter = new TourConverter();


    public TourDto createTour(TourDto tourDto) {

        return tourConverter.convert(tourDao.save(tourConverter.convert(tourDto)));
    }

    public List<TourDto> checkExistenceTours(){

        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public TourDto editTour(TourDto tourDto) {

        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public List<TourDto> viewOrderHystory(UUID clientId) {

        return  tourDao.getToursById(clientId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());

    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        return null;
    }

    public TravelAgencyDto getTravelAgency(UUID id){

        return travelAgencyConverter.convert(travelAgencyDao.getById(id));
    }

    @Override
    public List<TravelAgentDto> getAll() {
        return null;
    }
}
