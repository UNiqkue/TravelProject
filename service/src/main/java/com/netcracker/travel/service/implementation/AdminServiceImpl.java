package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminMapper;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.dto.AdminDTO;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@Transactional
public class AdminServiceImpl implements BaseService<AdminDTO> {

    private final AdminRepository adminRepository;

    private AdminMapper adminMapper = Mappers.getMapper(AdminMapper.class);

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<AdminDTO> getAll() {
        log.info("AdminServiceImpl findAll");
        return StreamSupport.stream(adminRepository.findAll().spliterator(), false)
                .map(adminMapper::adminToAdminDTO)
                .collect(Collectors.toList());
    }

    public AdminDTO getByName(String username) {
        log.info("AdminServiceImpl getByName admin with username: {}", username);
        return adminMapper.adminToAdminDTO(adminRepository.findByUsername(username));
    }

    public AdminDTO getById(String id) {
        log.info("AdminServiceImpl getById admin with id: {} ", id);
        return adminMapper.adminToAdminDTO(adminRepository.findByUsername(id));
    }

    public AdminDTO save(AdminDTO adminDto) {
        log.info("AdminServiceImpl save admin: {}", adminDto.toString());
        adminDto.setId(UUID.randomUUID().toString());
        adminDto.setRole(Role.ADMIN);
        adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        return adminMapper.adminToAdminDTO(adminRepository.save(adminMapper.adminDTOtoAdmin(adminDto)));
    }

    public AdminDTO update(String id, AdminDTO adminDto) {
        log.info("AdminServiceImpl update admin: {}", adminDto.toString());
        adminDto.setId(id);
        return adminMapper.adminToAdminDTO(adminRepository.save(adminMapper.adminDTOtoAdmin(adminDto)));
    }

    public void delete(String id) {
        log.info("AdminServiceImpl delete admin with id: {} ", id);
        adminRepository.delete(id);
    }

}
