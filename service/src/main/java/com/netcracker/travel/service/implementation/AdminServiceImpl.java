package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.repository.AdminRepository;
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
public class AdminServiceImpl implements UserDetailsService, BaseEntityService<AdminDto> {

    private final AdminRepository adminRepository;
    private final AdminConverter adminConverter;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, AdminConverter adminConverter) {
        this.adminRepository = adminRepository;
        this.adminConverter = adminConverter;
    }

    @Transactional
    public AdminDto getByName(String username) {
        return adminConverter.convert(adminRepository.findByUsername(username));
    }

    @Transactional
    public List<AdminDto> getAll() {
        return StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                .map(adminConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public AdminDto getById(String id) {
        return adminConverter.convert(adminRepository.findByUsername(id));
    }

    @Transactional
    public AdminDto save(AdminDto adminDto) {
        adminDto.setId(UUID.randomUUID().toString());
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    @Transactional
    public AdminDto update(AdminDto adminDto) {
        return adminConverter.convert(adminRepository.save(adminConverter.convert(adminDto)));
    }

    @Transactional
    public void delete(String id) {
        adminRepository.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) adminRepository.findByUsername(s);
    }
}
