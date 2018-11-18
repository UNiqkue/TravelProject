package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.*;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto>, AuthenticationService {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();
    private TourConverter tourConverter = new TourConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();


    public TourDto createTour(TourDto tourDto) throws SQLException {
        return tourConverter.convert(tourDao.save(tourConverter.convert(tourDto)));
    }

    public List<TourDto> checkExistenceTours() throws SQLException{
        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public TourDto editTour(TourDto tourDto) throws SQLException {
        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public List<TourDto> viewOrderHystory(UUID clientId) throws SQLException{
        return  tourDao.getToursById(clientId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());

    }

    public boolean login(LoginRequestDto loginRequestDto){
        TravelAgentDto travelAgentDto = travelAgentConverter.convert(travelAgentDao.getByUsername(loginRequestDto.getUsername()));
        if (travelAgentDto.getPassword().equals(loginRequestDto.getPassword())) {
            return true;
        }
        return false;
    }

    public TravelAgencyDto getTravelAgency(UUID id) throws SQLException{
        return travelAgencyConverter.convert(travelAgencyDao.getById(id));
    }

    @Override
    public List<TravelAgentDto> getAll() {
        return null;
    }
}

