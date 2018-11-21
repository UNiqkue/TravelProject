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
import java.util.stream.Collectors;

public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto> {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();
    private TourConverter tourConverter = new TourConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();

    public TravelAgentServiceImpl(){}

    public TourDto createTour() {
        TourDto tourDto = new TourDto();
        return tourConverter.convert(tourDao.save(tourConverter.convert(tourDto)));
    }

    public List<TourDto> checkExistenceTours(){
        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public TourDto editTour(UUID id) {
        return tourConverter.convert(tourDao.update(tourDao.getById(id)));
    }

    public List<TourDto> viewOrderHystory() {
        String clientId = "00000000-0000-0000-0000-000000000000";
        return  tourDao.getAll()
                .stream()
                .filter(tour -> !(tour.getCustomerId().toString().equals(clientId)))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());

    }

    public TravelAgencyDto getTravelAgency(UUID id){
        return travelAgencyConverter.convert(travelAgencyDao.getById(id));
    }

    public List<TravelAgentDto> getAll() {
        return null;
    }

    public void makeDiscount() {
    }

    public void deleteTour(UUID id) {
        tourDao.delete(id);
    }
}
