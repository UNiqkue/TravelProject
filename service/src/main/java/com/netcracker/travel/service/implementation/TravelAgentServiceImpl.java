package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dto.TravelAgentDTO;
import com.netcracker.travel.repository.TravelAgentRepository;
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
public class TravelAgentServiceImpl implements BaseService<TravelAgentDTO> {

    private final TravelAgentRepository travelAgentRepository;

    private final TravelAgentConverter travelAgentConverter;

    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository travelAgentRepository, TravelAgentConverter travelAgentConverter) {
        this.travelAgentRepository = travelAgentRepository;
        this.travelAgentConverter = travelAgentConverter;
    }

    public List<TravelAgentDTO> getAll() {
        log.info("TravelAgentServiceImpl getAll");
        return StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
                .map(travelAgentConverter::convert)
                .collect(Collectors.toList());
    }

    public TravelAgentDTO getByName(String username) {
        log.info("TravelAgentServiceImpl getByName travelAgent with username: {}", username);
        return travelAgentConverter.convert(travelAgentRepository.findByUsername(username));
    }

    public TravelAgentDTO getById(String id) {
        log.info("TravelAgentServiceImpl getById travelAgent with id: {} ", id);
        return travelAgentConverter.convert(travelAgentRepository.findById(id));
    }

    public TravelAgentDTO save(TravelAgentDTO travelAgentDto) {
        log.info("TravelAgentServiceImpl save travelAgent: {}", travelAgentDto.toString());
        travelAgentDto.setId(UUID.randomUUID().toString());
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    public TravelAgentDTO update(TravelAgentDTO travelAgentDto) {
        log.info("TravelAgentServiceImpl update travelAgent: {}", travelAgentDto.toString());
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    public void delete(String id) {
        log.info("TravelAgentServiceImpl delete travelAgent with id: {} ", id);
        travelAgentRepository.delete(id);
    }
}
