package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.dto.TravelAgencyDTO;
import com.netcracker.travel.repository.TravelAgencyRepository;
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
public class TravelAgencyServiceImpl implements BaseService<TravelAgencyDTO> {

    private final TravelAgencyRepository travelAgencyRepository;

    private final TravelAgencyConverter travelAgencyConverter;

    @Autowired
    public TravelAgencyServiceImpl(TravelAgencyRepository travelAgencyRepository, TravelAgencyConverter travelAgencyConverter) {
        this.travelAgencyRepository = travelAgencyRepository;
        this.travelAgencyConverter = travelAgencyConverter;
    }

    public List<TravelAgencyDTO> getAll() {
        log.info("TravelAgencyServiceImpl findAll");
        return StreamSupport.stream(travelAgencyRepository.findAll().spliterator(), false)
                .map(travelAgencyConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TravelAgencyDTO> getByName(String name) {
        log.info("TravelAgencyServiceImpl getByName travelAgency with name: {}", name);
        return travelAgencyRepository.findByName(name).stream()
                .map(travelAgencyConverter::convert)
                .collect(Collectors.toList());
    }

    public TravelAgencyDTO getById(String id) {
        log.info("TravelAgencyServiceImpl getById travelAgency with id: {} ", id);
        return travelAgencyConverter.convert(travelAgencyRepository.getById(id));
    }

    public TravelAgencyDTO save(TravelAgencyDTO travelAgencyDto) {
        log.info("TravelAgencyServiceImpl save travelAgency: {}", travelAgencyDto.toString());
        travelAgencyDto.setId(UUID.randomUUID().toString());
        return travelAgencyConverter.convert(travelAgencyRepository.save(travelAgencyConverter.convert(travelAgencyDto)));
    }

    public TravelAgencyDTO update(TravelAgencyDTO travelAgencyDto) {
        log.info("TravelAgencyServiceImpl update travelAgency: {}", travelAgencyDto.toString());
        return travelAgencyConverter.convert(travelAgencyRepository.save(travelAgencyConverter.convert(travelAgencyDto)));
    }

    public void delete(String id) {
        log.info("TravelAgencyServiceImpl delete travelAgency with id: {} ", id);
        travelAgencyRepository.delete(id);
    }
}
