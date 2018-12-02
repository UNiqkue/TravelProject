package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.AdminDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.service.interfaces.AbstractService;

import java.util.List;
import java.util.UUID;

public class AdminServiceImpl implements AbstractService<AdminDto> {

    private AdminDaoImpl adminDao = AdminDaoImpl.getInstance();
    private TourDaoImpl tourDao = TourDaoImpl.getInstance();

    private AdminConverter adminConverter = new AdminConverter();
    private TourConverter tourConverter = new TourConverter();

    public AdminServiceImpl(){
    }

    public AdminDto getByUsername(String username) {
        return null;
    }

    public List<AdminDto> getAll() {
        return null;
    }

    public List<TourDto> watchTours() {
        return null;
    }

    public TravelAgency createTravelAgency(){
        return null;
    }

    public AdminDto updateInfo(UUID id){
        return null;
    }

    public AdminDto checkInfo(UUID id){
        return null;
    }


}
