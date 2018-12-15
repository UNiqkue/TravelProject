package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.repository.AdminRepository;
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
@Service
@Transactional
public class AdminServiceImpl implements BaseService<AdminDto> {

    private final AdminRepository adminRepository;

    private final AdminConverter adminConverter;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, AdminConverter adminConverter) {
        this.adminRepository = adminRepository;
        this.adminConverter = adminConverter;
    }

    public List<AdminDto> getAll() {
        log.info("AdminServiceImpl findAll");
        return StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                .map(adminConverter::convert)
                .collect(Collectors.toList());
    }

    public AdminDto getByName(String username) {
        log.info("AdminServiceImpl getByName admin with username: {}", username);
        return adminConverter.convert(adminRepository.findByUsername(username));
    }

    public AdminDto getById(String id) {
        log.info("AdminServiceImpl getById admin with id: {} ", id);
        return adminConverter.convert(adminRepository.findByUsername(id));
    }

    public AdminDto save(AdminDto adminDto) {
        log.info("AdminServiceImpl save admin: {}", adminDto.toString());
        adminDto.setId(UUID.randomUUID().toString());
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    public AdminDto update(AdminDto adminDto) {
        log.info("AdminServiceImpl update admin: {}", adminDto.toString());
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    public void delete(String id) {
        log.info("AdminServiceImpl delete admin with id: {} ", id);
        adminRepository.delete(id);
    }

}
