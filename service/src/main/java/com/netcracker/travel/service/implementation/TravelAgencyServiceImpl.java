package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.repository.TravelAgencyRepository;
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
public class TravelAgencyServiceImpl implements BaseEntityService<TravelAgencyDto> {

    private final Logger logger = LoggerFactory.getLogger(TravelAgencyServiceImpl.class);

    private final TravelAgencyRepository travelAgencyRepository;

    private final TravelAgencyConverter travelAgencyConverter;

    @Autowired
    public TravelAgencyServiceImpl(TravelAgencyRepository travelAgencyRepository, TravelAgencyConverter travelAgencyConverter) {
        this.travelAgencyRepository = travelAgencyRepository;
        this.travelAgencyConverter = travelAgencyConverter;
    }

    @Transactional
    public List<TravelAgencyDto> getAll() {
        logger.info("TravelAgencyServiceImpl findAll");
        return StreamSupport.stream(travelAgencyRepository.findAll().spliterator(), false)
                .map(travelAgencyConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TravelAgencyDto> getByName(String name) {
        logger.info("TravelAgencyServiceImpl getByName travelAgency with name: {}", name);
        return travelAgencyRepository.findByName(name).stream()
                .map(travelAgencyConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public TravelAgencyDto getById(String id) {
        logger.info("TravelAgencyServiceImpl getById travelAgency with id: {} ", id);
        return travelAgencyConverter.convert(travelAgencyRepository.getById(id));
    }

    @Transactional
    public TravelAgencyDto save(TravelAgencyDto travelAgencyDto) {
        logger.info("TravelAgencyServiceImpl save travelAgency: {}", travelAgencyDto.toString());
        travelAgencyDto.setId(UUID.randomUUID().toString());
        return travelAgencyConverter.convert(travelAgencyRepository.save(travelAgencyConverter.convert(travelAgencyDto)));
    }

    @Transactional
    public TravelAgencyDto update(TravelAgencyDto travelAgencyDto) {
        logger.info("TravelAgencyServiceImpl update travelAgency: {}", travelAgencyDto.toString());
        return travelAgencyConverter.convert(travelAgencyRepository.save(travelAgencyConverter.convert(travelAgencyDto)));
    }

    @Transactional
    public void delete(String id) {
        logger.info("TravelAgencyServiceImpl delete travelAgency with id: {} ", id);
        travelAgencyRepository.delete(id);
    }
}
