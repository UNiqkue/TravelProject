package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.repository.AdminRepository;
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
public class AdminServiceImpl implements UserDetailsService, BaseEntityService<AdminDto> {

    private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    private final AdminRepository adminRepository;

    private final AdminConverter adminConverter;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, AdminConverter adminConverter) {
        this.adminRepository = adminRepository;
        this.adminConverter = adminConverter;
    }

    @Transactional
    public List<AdminDto> getAll() {
        logger.info("AdminServiceImpl findAll");
        return StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                .map(adminConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public AdminDto getByName(String username) {
        logger.info("AdminServiceImpl getByName admin with username: {}", username);
        return adminConverter.convert(adminRepository.findByUsername(username));
    }

    @Transactional
    public AdminDto getById(String id) {
        logger.info("AdminServiceImpl getById admin with id: {} ", id);
        return adminConverter.convert(adminRepository.findByUsername(id));
    }

    @Transactional
    public AdminDto save(AdminDto adminDto) {
        logger.info("AdminServiceImpl save admin: {}", adminDto.toString());
        adminDto.setId(UUID.randomUUID().toString());
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    @Transactional
    public AdminDto update(AdminDto adminDto) {
        logger.info("AdminServiceImpl update admin: {}", adminDto.toString());
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    @Transactional
    public void delete(String id) {
        logger.info("AdminServiceImpl delete admin with id: {} ", id);
        adminRepository.delete(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("AdminServiceImpl loadUserByUsername admin with username: {}", username);
        return (UserDetails) adminRepository.findByUsername(username);
    }
}
