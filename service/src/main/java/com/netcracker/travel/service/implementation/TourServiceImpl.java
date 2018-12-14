package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.service.BaseEntityService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class TourServiceImpl implements BaseEntityService<TourDto> {

    private final Logger logger = LoggerFactory.getLogger(TourServiceImpl.class);

    private final TourRepository tourRepository;

    private final TourConverter tourConverter;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, TourConverter tourConverter) {
        this.tourRepository = tourRepository;
        this.tourConverter = tourConverter;
    }

    @Transactional
    public List<TourDto> getAll() {
        logger.info("TourServiceImpl findAll");
        return StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TourDto> getByName(String name) {
        logger.info("TourServiceImpl getByName tour with name: {}", name);
        return tourRepository.findByName(name).stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public TourDto getById(String id) {
        logger.info("TourServiceImpl getById tour with id: {} ", id);
        return tourConverter.convert(tourRepository.getById(id));
    }

    @Transactional
    public TourDto save(TourDto tourDto) {
        logger.info("TourServiceImpl save tour: {}", tourDto.toString());
        tourDto.setId(UUID.randomUUID().toString());
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    @Transactional
    public TourDto update(TourDto tourDto) {
        logger.info("TourServiceImpl update tour: {}", tourDto.toString());
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    @Transactional
    public void delete(String id) {
        logger.info("TourServiceImpl delete tour with id: {} ", id);
        tourRepository.delete(id);
    }
}
