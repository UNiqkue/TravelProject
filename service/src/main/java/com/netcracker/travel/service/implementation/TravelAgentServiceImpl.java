package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.repository.TravelAgentRepository;
import com.netcracker.travel.service.BaseEntityService;
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

@Service
public class TravelAgentServiceImpl implements UserDetailsService, BaseEntityService<TravelAgentDto> {

    private final TravelAgentRepository travelAgentRepository;
    private final TravelAgentConverter travelAgentConverter;

    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository travelAgentRepository, TravelAgentConverter travelAgentConverter) {
        this.travelAgentRepository = travelAgentRepository;
        this.travelAgentConverter = travelAgentConverter;
    }

    @Transactional
    public List<TravelAgentDto> getAll() {
        return StreamSupport.stream(travelAgentRepository.findAll().spliterator(), false)
                .map(travelAgentConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public TravelAgentDto getByName(String username) {
        return travelAgentConverter.convert(travelAgentRepository.findByUsername(username));
    }

    @Transactional
    public TravelAgentDto getById(String id) {
        return travelAgentConverter.convert(travelAgentRepository.findById(id));
    }

    @Transactional
    public TravelAgentDto save(TravelAgentDto travelAgentDto) {
        travelAgentDto.setId(UUID.randomUUID().toString());
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    @Transactional
    public TravelAgentDto update(TravelAgentDto travelAgentDto) {
        return travelAgentConverter.convert(travelAgentRepository.save(travelAgentConverter.convert(travelAgentDto)));
    }

    @Transactional
    public void delete(String id) {
        travelAgentRepository.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
