package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgencyConverter;
import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.repository.TravelAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TravelAgencyServiceImpl {

    private final TravelAgencyRepository travelAgencyRepository;
    private final TravelAgencyConverter travelAgencyConverter;

    @Autowired
    public TravelAgencyServiceImpl(TravelAgencyRepository travelAgencyRepository, TravelAgencyConverter travelAgencyConverter) {
        this.travelAgencyRepository = travelAgencyRepository;
        this.travelAgencyConverter = travelAgencyConverter;
    }

    @Transactional
    public List<TravelAgencyDto> getAll() {
        return StreamSupport.stream(travelAgencyRepository.findAll().spliterator(), false)
                .map(travelAgencyConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public TravelAgencyDto add(TravelAgencyDto travelAgencyDto) {
        travelAgencyDto.setId(UUID.randomUUID().toString().replace("-", ""));
        return travelAgencyConverter.convert(travelAgencyRepository.save(travelAgencyConverter.convert(travelAgencyDto)));
    }

    @Transactional
    public TravelAgencyDto getById(String id) {
        return travelAgencyConverter.convert(travelAgencyRepository.getById(id));
    }

    @Transactional
    public TravelAgencyDto update(TravelAgencyDto travelAgencyDto) {
        return travelAgencyConverter.convert(travelAgencyRepository.save(travelAgencyConverter.convert(travelAgencyDto)));
    }

    @Transactional
    public void delete(String id) {
        travelAgencyRepository.delete(id);
    }
}