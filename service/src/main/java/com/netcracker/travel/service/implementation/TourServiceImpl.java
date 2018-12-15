package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Transactional
@Service
public class TourServiceImpl implements BaseService<TourDto> {

    private final TourRepository tourRepository;

    private final TourConverter tourConverter;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, TourConverter tourConverter) {
        this.tourRepository = tourRepository;
        this.tourConverter = tourConverter;
    }

    public List<TourDto> getAll() {
        log.info("TourServiceImpl findAll");
        return StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TourDto> getByName(String name) {
        log.info("TourServiceImpl getByName tour with name: {}", name);
        return tourRepository.findByName(name).stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public TourDto getById(String id) {
        log.info("TourServiceImpl getById tour with id: {} ", id);
        return tourConverter.convert(tourRepository.getById(id));
    }

    public TourDto save(TourDto tourDto) {
        log.info("TourServiceImpl save tour: {}", tourDto.toString());
        tourDto.setId(UUID.randomUUID().toString());
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    public TourDto update(TourDto tourDto) {
        log.info("TourServiceImpl update tour: {}", tourDto.toString());
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    public void delete(String id) {
        log.info("TourServiceImpl delete tour with id: {} ", id);
        tourRepository.delete(id);
    }
}
