package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.domain.Tour;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TourServiceImpl {

    private final TourRepository tourRepository;
    private final TourConverter tourConverter;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, TourConverter tourConverter) {
        this.tourRepository = tourRepository;
        this.tourConverter = tourConverter;
    }

    public List<TourDto> getAll() {
        return StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public TourDto addTour(TourDto tourDto) {
        tourDto.setId(UUID.randomUUID().toString().replace("-", ""));
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    public TourDto updateTour(TourDto tourDto) {
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }


    public TourDto getTour(String id) {
        Tour tour = tourRepository.findOne(id);
        return tour != null ? tourConverter.convert(tour) : null;
       // return tourConverter.convert(tourRepository.findOne(UUID.fromString(id)));
    }

    public void deleteTour(String id) {
            tourRepository.delete(id);
    }
}
