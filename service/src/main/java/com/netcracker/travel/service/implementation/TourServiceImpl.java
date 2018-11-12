package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.service.interfaces.AbstractService;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class TourServiceImpl implements AbstractService<TourDto> {

    private TourConverter tourConverter;

    public TourDto getById(UUID id) {
        return null;
    }

    public TourDto getByName(String name) {
        return null;
    }

    public Collection<TourDto> getAll() {
        TourDaoImpl tourDaoImpl = TourDaoImpl.getInstance();
        return tourDaoImpl.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public void save(TourDto tourDto) {
        TourDaoImpl tourDaoImpl = TourDaoImpl.getInstance();
        tourDaoImpl.save(tourConverter.convert(tourDto));
    }

    public void update(TourDto tourDto) {
    }

    public void delete(UUID id) {
    }

    public CustomerDto getCustomer(){return null;}

}
