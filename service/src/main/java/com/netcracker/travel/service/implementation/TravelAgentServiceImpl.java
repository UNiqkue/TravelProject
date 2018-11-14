package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.TravelAgent;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;

import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

public class TravelAgentServiceImpl implements AbstractService<TravelAgent>, AuthenticationService {

    private TourDaoImpl tourDao;
    private TravelAgencyDaoImpl travelAgencyDao;
    private TravelAgentDaoImpl travelAgentDao;
    private TravelAgencyConverter converter;


    public Tour createTour(Tour tour, UUID customerId) {
        tour.setCustomerId(customerId);
        Tour temp = null;
        try {
            temp = tourDao.save(tour);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public Collection<Tour> checkExistenceTours(){
        Collection<Tour> tours = null;
        try {
            tours = tourDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    public Tour editTour(Tour tour) {
            Tour temp = null;
            try {
                temp = tourDao.update(tour);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return temp;
    }

    public Collection<Tour> viewOrderHystory(UUID clientId){
        Collection<Tour> temp = null;
        try {
            temp = tourDao.getTourByCustomerId(clientId);
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
                temp = converter.convert(travelAgencyDao.getById(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return temp;
    }
}
