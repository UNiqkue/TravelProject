package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerMapper;
import com.netcracker.travel.converter.TourMapper;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.TourDTO;
import com.netcracker.travel.entity.enumeration.TypeTour;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.repository.TravelAgencyRepository;
import com.netcracker.travel.service.BaseService;
import com.netcracker.travel.service.SearchTourService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Transactional
@Service
public class TourServiceImpl implements BaseService<TourDTO>, SearchTourService {

    private final TourRepository tourRepository;

    private final TravelAgencyRepository travelAgencyRepository;

    private TourMapper tourMapper = Mappers.getMapper(TourMapper.class);

    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, TravelAgencyRepository travelAgencyRepository) {
        this.tourRepository = tourRepository;
        this.travelAgencyRepository = travelAgencyRepository;
    }

    public List<TourDTO> getAll() {
        log.info("TourServiceImpl findAll");
        return StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> getByName(String name) {
        log.info("TourServiceImpl getByName tour with name: {}", name);
        return tourRepository.findByName(name).stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public TourDTO getById(String id) {
        log.info("TourServiceImpl getById tour with id: {} ", id);
        return tourMapper.tourToTourDTO(tourRepository.getById(id));
    }

    public TourDTO save(TourDTO tourDto) {
        tourDto.setId(UUID.randomUUID().toString());
        log.info("TourServiceImpl save tour: {}", tourDto.toString());
        return tourMapper.tourToTourDTO(tourRepository.save(tourMapper.tourDTOtoTour(tourDto)));
    }

    public TourDTO update(String id, TourDTO tourDto) {
        tourDto.setId(id);
        log.info("TourServiceImpl update tour: {}", tourDto.toString());
        return tourMapper.tourToTourDTO(tourRepository.save(tourMapper.tourDTOtoTour(tourDto)));
    }

    public void delete(String id) {
        log.info("TourServiceImpl delete tour with id: {} ", id);
        tourRepository.delete(id);
    }

    public List<TourDTO> watchCustomerTours(CustomerDTO customerDTO) {
        return tourRepository.findAllByCustomer(customerMapper.customerDTOtoCustomer(customerDTO))
                .stream()
                .map(tour -> tourMapper.tourToTourDTO(tour))
                .collect(Collectors.toList());
    }

    public TourDTO buyTour(String tourId, CustomerDTO customerDTO) {
        TourDTO tourDto = tourMapper.tourToTourDTO(tourRepository.getById(tourId));
//        if (customerDTO.getId().equals(tourDto.getCustomer().getId()) || tourDto.isFree()) {
//            tourDto.setCustomer(customerMapper.customerDTOtoCustomer(customerDTO));
//            tourDto.setFree(false);
//            tourDto = tourMapper.tourToTourDTO(tourRepository.save(tourMapper.tourDTOtoTour(tourDto)));
//            System.out.println("You bought tour");
//        } else {
//            System.out.println("You can't do it!!!");
//        }
        return tourDto;
    }

    public TourDTO cancelTour(String tourId, String userId) {
        TourDTO tourDto = tourMapper.tourToTourDTO(tourRepository.getById(tourId));
//        if (userId.equals(tourDto.getCustomer().getId())) {
//            tourDto.setFree(true);
//            tourDto.setCustomer(null);
//            tourDto = tourMapper.tourToTourDTO(tourRepository.save(tourMapper.tourDTOtoTour(tourDto)));
//        } else {
//            System.out.println("You can't do it!!!");
//        }
        return tourDto;
    }

    public List<TourDTO> searchTourByName(String name) {
        return tourRepository.findByName(name)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByStartDate(Date startDate) {
        return tourRepository.findByStartDate(startDate)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByEndDate(Date endDate) {
        return tourRepository.findByEndDate(endDate)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByType(TypeTour type) {
        return tourRepository.findByType(type)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByCountry(String country) {
        return tourRepository.findByCountry(country)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByTravelAgency(String name) {
        return tourRepository.findByTravelAgency(travelAgencyRepository.findByName(name).get(0))
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }
}
