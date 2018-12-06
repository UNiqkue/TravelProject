package com.netcracker.travel.service.implementation;

import javax.persistence.*;
import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.service.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AbstractService<AdminDto> {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private AdminConverter adminConverter;
    @Autowired
    private TourConverter tourConverter;

    public AdminServiceImpl() {
    }

    public AdminDto getByUsername(String username) {
        return adminConverter.convert(adminRepository.findByUsername(username));
    }

    public List<AdminDto> getAll() {
        /* StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                .map(user -> adminConverter.convert(user))
                .collect(Collectors.toList());*/
        return adminRepository.findAll()
                .stream()
                .map(user -> adminConverter.convert(user))
                .collect(Collectors.toList());
    }

    public List<TourDto> watchTours() {
        return tourRepository.findAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }


}
