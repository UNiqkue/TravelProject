package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminServiceImpl implements AbstractService<AdminDto> {

    private final AdminRepository adminRepository;
    private final AdminConverter adminConverter;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, AdminConverter adminConverter) {
        this.adminRepository = adminRepository;
        this.adminConverter = adminConverter;
    }

    public AdminDto getByUsername(String username) {
        return adminConverter.convert(adminRepository.findByUsername(username));
    }

    public List<AdminDto> getAll() {
        return StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                .map(adminConverter::convert)
                .collect(Collectors.toList());
    }

    public AdminDto getById(String id) {
        return adminConverter.convert(adminRepository.findByUsername(id));
    }

    public AdminDto save(AdminDto adminDto) {
        adminDto.setId(UUID.randomUUID().toString());
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    public AdminDto update(AdminDto adminDto) {
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    public void delete(String id) {
        adminRepository.delete(id);
    }
}
