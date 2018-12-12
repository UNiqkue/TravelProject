package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.repository.TravelAgentRepository;
import com.netcracker.travel.service.AbstractService;
import com.netcracker.travel.service.CrudTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TravelAgentServiceImpl implements AbstractService<TravelAgentDto>, CrudTourService<TourDto> {

    private final TourRepository tourRepository;
    private final TravelAgentRepository travelAgentRepository;
    private final TourConverter tourConverter;
    private final TravelAgentConverter travelAgentConverter;

    @Autowired
    public TravelAgentServiceImpl(TourRepository tourRepository, TravelAgentRepository travelAgentRepository, TourConverter tourConverter, TravelAgentConverter travelAgentConverter) {
        this.tourRepository = tourRepository;
        this.travelAgentRepository = travelAgentRepository;
        this.tourConverter = tourConverter;
        this.travelAgentConverter = travelAgentConverter;
    }

    public TourDto createTour(TourDto tourDto) {
       // tourDto.setId(UUID.randomUUID());
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    public List<TourDto> getExistenceTours() {
        return StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TourDto> watchTours() {
        String clientId = "00000000-0000-0000-0000-000000000000";
        return StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .filter(tour -> !(tour/*.getCustomer()*/.getId().equals(clientId)))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TravelAgentDto> getAll() {
        return StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
                .map(travelAgent -> travelAgentConverter.convert(travelAgent))
                .collect(Collectors.toList());
    }

    public TravelAgentDto getByUsername(String username) {
        return /*travelAgentConverter.convert(travelAgentRepository.findByUsername(username))*/ null;
    }

    public TourDto makeDiscount(UUID id, Double price) {
        TourDto tourDto = tourConverter.convert(tourRepository.getById(id.toString()));
        tourDto.setPrice(price);
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    } /**updatePrice**/

    public TourDto editTour(UUID id, String description) {
        TourDto tourDto = tourConverter.convert(tourRepository.getById(id.toString()));
        tourDto.setDescription(description);
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }/**updateDescription**/

    public void deleteTour(UUID id) {
        tourRepository.delete(id.toString());
    }
}
