package com.netcracker.travel.service.implementation;

import com.netcracker.travel.dao.implementation.TravelAgencyDaoImpl;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.service.interfaces.AbstractService;

import java.util.List;
import java.util.UUID;

public class TravelAgencyServiceImpl implements AbstractService<TravelAgencyDto> {

    private TravelAgencyDaoImpl travelAgencyDaoImpl;

    public TravelAgencyServiceImpl(){
        travelAgencyDaoImpl = TravelAgencyDaoImpl.getInstance();
    }

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
