package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.service.interfaces.AbstractService;

import java.util.List;
import java.util.UUID;

public class TourServiceImpl implements AbstractService<TourDto> {

    private TourDaoImpl tourDaoImpl;
    private TourConverter tourConverter;

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
      //  tourDaoImpl.save();
//        return tourDaoImpl.getAll()
//                .stream()
//                .map(tour -> tourConverter.convert(tour))
//                .collect(Collectors.toList());
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
