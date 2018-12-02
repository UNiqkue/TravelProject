package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.AdminDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.service.interfaces.AbstractService;

import java.util.List;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AbstractService<AdminDto> {

    private AdminDaoImpl adminDao = AdminDaoImpl.getInstance();
    private TourDaoImpl tourDao = TourDaoImpl.getInstance();

    private AdminConverter adminConverter = new AdminConverter();
    private TourConverter tourConverter = new TourConverter();

    public AdminServiceImpl() {
    }

    public AdminDto getByUsername(String username) {
        return adminConverter.convert(adminDao.getByUsername(username));
    }

    public List<AdminDto> getAll() {
        return adminDao.getAll()
                .stream()
                .map(user -> adminConverter.convert(user))
                .collect(Collectors.toList());
    }

    public List<TourDto> watchTours() {
        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }


}
