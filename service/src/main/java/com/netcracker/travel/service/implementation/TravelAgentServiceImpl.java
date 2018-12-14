package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.repository.TravelAgentRepository;
import com.netcracker.travel.service.BaseEntityService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class TravelAgentServiceImpl implements UserDetailsService, BaseEntityService<TravelAgentDto> {

    private final Logger logger = LoggerFactory.getLogger(TravelAgentServiceImpl.class);

    private final TravelAgentRepository travelAgentRepository;

    private final TravelAgentConverter travelAgentConverter;

    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository travelAgentRepository, TravelAgentConverter travelAgentConverter) {
        this.travelAgentRepository = travelAgentRepository;
        this.travelAgentConverter = travelAgentConverter;
    }

    @Transactional
    public List<TravelAgentDto> getAll() {
        logger.info("TravelAgentServiceImpl getAll");
        return StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
                .map(travelAgentConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public TravelAgentDto getByName(String username) {
        logger.info("TravelAgentServiceImpl getByName travelAgent with username: {}", username);
        return travelAgentConverter.convert(travelAgentRepository.findByUsername(username));
    }

    @Transactional
    public TravelAgentDto getById(String id) {
        logger.info("TravelAgentServiceImpl getById travelAgent with id: {} ", id);
        return travelAgentConverter.convert(travelAgentRepository.findById(id));
    }

    @Transactional
    public TravelAgentDto save(TravelAgentDto travelAgentDto) {
        logger.info("TravelAgentServiceImpl save travelAgent: {}", travelAgentDto.toString());
        travelAgentDto.setId(UUID.randomUUID().toString());
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    @Transactional
    public TravelAgentDto update(TravelAgentDto travelAgentDto) {
        logger.info("TravelAgentServiceImpl update travelAgent: {}", travelAgentDto.toString());
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    @Transactional
    public void delete(String id) {
        logger.info("TravelAgentServiceImpl delete travelAgent with id: {} ", id);
        travelAgentRepository.delete(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("TravelAgentServiceImpl loadUserByUsername travelAgent with username: {}", username);
        return (UserDetails) travelAgentRepository.findByUsername(username);
    }
}
