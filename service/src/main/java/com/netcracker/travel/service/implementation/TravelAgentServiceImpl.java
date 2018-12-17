package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgentMapper;
import com.netcracker.travel.dto.TravelAgentDTO;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.repository.TravelAgentRepository;
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
public class TravelAgentServiceImpl implements BaseService<TravelAgentDTO> {

    private final TravelAgentRepository travelAgentRepository;

    private TravelAgentMapper travelAgentMapper = Mappers.getMapper(TravelAgentMapper.class);


    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository travelAgentRepository) {
        this.travelAgentRepository = travelAgentRepository;
    }

    public List<TravelAgentDTO> getAll() {
        log.info("TravelAgentServiceImpl getAll");
        return StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
                .map(travelAgentMapper::travelAgentToTravelAgentDTO)
                .collect(Collectors.toList());
    }

    public TravelAgentDTO getById(String id) {
        log.info("TravelAgentServiceImpl getById travelAgent with id: {} ", id);
        return travelAgentMapper.travelAgentToTravelAgentDTO(travelAgentRepository.findById(id));
    }

    public TravelAgentDTO save(TravelAgentDTO travelAgentDto) {
        log.info("TravelAgentServiceImpl save travelAgent: {}", travelAgentDto.toString());
        travelAgentDto.setId(UUID.randomUUID().toString());
        travelAgentDto.setRole(Role.TRAVELAGENT);
        return travelAgentMapper.travelAgentToTravelAgentDTO(travelAgentRepository.save(travelAgentMapper.travelAgentDTOtoTravelAgent(travelAgentDto)));
    }

    public TravelAgentDTO update(String id, TravelAgentDTO travelAgentDto) {
        log.info("TravelAgentServiceImpl update travelAgent: {}", travelAgentDto.toString());
        travelAgentDto.setId(id);
        return travelAgentMapper.travelAgentToTravelAgentDTO(travelAgentRepository.save(travelAgentMapper.travelAgentDTOtoTravelAgent(travelAgentDto)));
    }

    public void delete(String id) {
        log.info("TravelAgentServiceImpl delete travelAgent with id: {} ", id);
        travelAgentRepository.delete(id);
    }
}
