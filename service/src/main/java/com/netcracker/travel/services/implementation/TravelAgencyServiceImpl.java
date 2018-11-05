package com.netcracker.travel.services.implementation;

import com.netcracker.travel.daos.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.services.interfaces.AbstractService;

import java.util.List;
import java.util.UUID;

public class TravelAgencyServiceImpl<TravelAgency> implements AbstractService<TravelAgencyDto> {

    private TravelAgencyDaoImpl travelAgencyDaoImpl;

    public TravelAgencyDto getById(UUID id) {
        return null;
    }

    public TravelAgencyDto getByName(String name) {
        return null;
    }

    public List<TravelAgencyDto> getAll() {
        return null;
    }

    public TravelAgencyDto save(TravelAgencyDto travelAgencyDto) {
        return null;
    }

    public void update(TravelAgencyDto travelAgencyDto) {
    }

    public void delete(UUID id) {
    }

}
