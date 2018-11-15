package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgencyConverter;
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


    public TourDto createTour(TourDto tourDto) {
        TourDto temp = null;
        try {
            temp = tourConverter.convert(tourDao.save(tourConverter.convert(tourDto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public List<TourDto> checkExistenceTours(){
        List<TourDto> tours = null;
        try {
            tours = tourDao.getAll()
                    .stream()
                    .map(tour -> tourConverter.convert(tour))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    public TourDto editTour(TourDto tourDto) {
            TourDto temp = null;
            try {
                temp = tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return temp;
    }

    public List<TourDto> viewOrderHystory(UUID clientId){
        List<TourDto> temp = null;
        try {
            temp = tourDao.getToursById(clientId)
                    .stream()
                    .map(tour -> tourConverter.convert(tour))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;

    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    public TravelAgencyDto getTravelAgency(UUID id){
            TravelAgencyDto temp = null;
            try {
                temp = travelAgencyConverter.convert(travelAgencyDao.getById(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return temp;
    }

    @Override
    public List<TravelAgentDto> getAll() {
        return null;
    }
}
