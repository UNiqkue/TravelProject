package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.domain.enumeration.Role;
import com.netcracker.travel.dto.TravelAgentDTO;
import com.netcracker.travel.repository.TravelAgentRepository;
import com.netcracker.travel.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository travelAgentRepository, TravelAgentConverter travelAgentConverter, PasswordEncoder passwordEncoder) {
        this.travelAgentRepository = travelAgentRepository;
        this.travelAgentConverter = travelAgentConverter;
        this.passwordEncoder = passwordEncoder;
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
        travelAgentDto.setRole(Role.TRAVELAGENT);
        travelAgentDto.setPassword(passwordEncoder.encode(travelAgentDto.getPassword()));
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    public TravelAgentDTO update(String id, TravelAgentDTO travelAgentDto) {
        log.info("TravelAgentServiceImpl update travelAgent: {}", travelAgentDto.toString());
        travelAgentDto.setId(id);
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    public void delete(String id) {
        log.info("TravelAgentServiceImpl delete travelAgent with id: {} ", id);
        travelAgentRepository.delete(id);
    }
}
