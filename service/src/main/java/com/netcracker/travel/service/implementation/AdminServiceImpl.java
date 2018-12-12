package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminServiceImpl implements AbstractService<AdminDto> {

    private AdminRepository adminRepository;
    private TourRepository tourRepository;
    private AdminConverter adminConverter;
    private TourConverter tourConverter;

    public AdminServiceImpl(){
    }

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, TourRepository tourRepository, AdminConverter adminConverter, TourConverter tourConverter) {
        this.adminRepository = adminRepository;
        this.tourRepository = tourRepository;
        this.adminConverter = adminConverter;
        this.tourConverter = tourConverter;
    }

    public AdminDto getByUsername(String username) {
        return/* adminConverter.convert(adminRepository.findByUsername(username))*/ null;
    }

    public List<AdminDto> getAll() {
        return StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                .map(user -> adminConverter.convert(user))
                .collect(Collectors.toList());
    }

    public List<TourDto> watchTours() {
     /*   Iterable<Tour> tours = tourRepository.findAll();

        List<TourDto> dtos = new ArrayList<>();
        for (Tour tour : tours){
            dtos.add(tourConverter.convert(tour));
        }*/
        return /*dtos*/ StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }


}
