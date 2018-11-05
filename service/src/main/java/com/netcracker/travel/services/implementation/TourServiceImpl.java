package com.netcracker.travel.services.implementation;

import com.netcracker.travel.daos.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.services.interfaces.AbstractService;

import java.util.List;
import java.util.UUID;

public class TourServiceImpl<T> implements AbstractService<TourDto> {

    private TourDaoImpl tourDaoImpl;

    public TourServiceImpl(){
        tourDaoImpl = TourDaoImpl.getInstance();
    }

    public TourDto getById(UUID id) {
        return null;
    }

    public TourDto getByName(String name) {
        return null;
    }

    public List<TourDto> getAll() {
        return null;
    }

    public TourDto save(TourDto tourDto) {
        return null;
    }

    public void update(TourDto tourDto) {
    }

    public void delete(UUID id) {
    }

    public CustomerDto getCustomer(){return null;}

}
