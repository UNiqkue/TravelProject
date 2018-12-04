package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.CrudTourService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto>, CrudTourService<TourDto> {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private TravelAgencyDaoImpl travelAgencyDao = TravelAgencyDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private TravelAgencyConverter travelAgencyConverter = new TravelAgencyConverter();
    private TourConverter tourConverter = new TourConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();

    public TravelAgentServiceImpl() {
    }

    public TourDto createTour(TourDto tourDto) {
        tourDto.setId(UUID.randomUUID());
        return tourConverter.convert(tourDao.save(tourConverter.convert(tourDto)));
    }

    public List<TourDto> getExistenceTours() {
        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> watchTours() {
        String clientId = "00000000-0000-0000-0000-000000000000";
        return tourDao.getAll()
                .stream()
                .filter(tour -> !(tour.getCustomerId().toString().equals(clientId)))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TravelAgentDto> getAll() {
        return travelAgentDao.getAll()
                .stream()
                .map(travelAgent -> travelAgentConverter.convert(travelAgent))
                .collect(Collectors.toList());
    }

    public TravelAgentDto getByUsername(String username) {
        return travelAgentConverter.convert(travelAgentDao.getByUsername(username));
    }

    public TourDto makeDiscount(UUID id, Double price) {
        TourDto tourDto = tourConverter.convert(tourDao.getById(id));
        tourDto.setPrice(price);
        return tourConverter.convert(tourDao.updatePrice(tourConverter.convert(tourDto)));
    }

    public TourDto editTour(UUID id, String description) {
        TourDto tourDto = tourConverter.convert(tourDao.getById(id));
        tourDto.setDescription(description);
        return tourConverter.convert(tourDao.updateDescription(tourConverter.convert(tourDto)));
    }

    public void deleteTour(UUID id) {
        tourDao.delete(id);
    }
}
