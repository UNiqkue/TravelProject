package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgencyMapper;
import com.netcracker.travel.dto.TravelAgencyDTO;
import com.netcracker.travel.repository.TravelAgencyRepository;
import com.netcracker.travel.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
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

    private TravelAgencyMapper travelAgencyMapper = Mappers.getMapper(TravelAgencyMapper.class);

    @Autowired
    public TravelAgencyServiceImpl(TravelAgencyRepository travelAgencyRepository) {
        this.travelAgencyRepository = travelAgencyRepository;
    }

    public List<TravelAgencyDTO> getAll() {
        log.info("TravelAgencyServiceImpl findAll");
        return StreamSupport.stream(travelAgencyRepository.findAll().spliterator(), false)
                .map(travelAgencyMapper::travelAgencyToTravelAgencyDTO)
                .collect(Collectors.toList());
    }

    public List<TravelAgencyDTO> getByName(String name) {
        log.info("TravelAgencyServiceImpl getByName travelAgency with name: {}", name);
        return travelAgencyRepository.findByName(name).stream()
                .map(travelAgencyMapper::travelAgencyToTravelAgencyDTO)
                .collect(Collectors.toList());
    }

    public TravelAgencyDTO getById(String id) {
        log.info("TravelAgencyServiceImpl getById travelAgency with id: {} ", id);
        return travelAgencyMapper.travelAgencyToTravelAgencyDTO(travelAgencyRepository.getById(id));
    }

    public TravelAgencyDTO save(TravelAgencyDTO travelAgencyDto) {
        log.info("TravelAgencyServiceImpl save travelAgency: {}", travelAgencyDto.toString());
        travelAgencyDto.setId(UUID.randomUUID().toString());
        return travelAgencyMapper.travelAgencyToTravelAgencyDTO(travelAgencyRepository.save(travelAgencyMapper.travelAgencyDTOtoTravelAgency(travelAgencyDto)));
    }

    public TravelAgencyDTO update(String id, TravelAgencyDTO travelAgencyDto) {
        log.info("TravelAgencyServiceImpl update travelAgency: {}", travelAgencyDto.toString());
        travelAgencyDto.setId(id);
        return travelAgencyMapper.travelAgencyToTravelAgencyDTO(travelAgencyRepository.save(travelAgencyMapper.travelAgencyDTOtoTravelAgency(travelAgencyDto)));
    }

    public void delete(String id) {
        log.info("TravelAgencyServiceImpl delete travelAgency with id: {} ", id);
        travelAgencyRepository.delete(id);
    }
}
