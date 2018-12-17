package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminMapper;
import com.netcracker.travel.dto.AdminDTO;
import com.netcracker.travel.entity.Admin;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.ResourceNotFoundException;
import com.netcracker.travel.exception.UnnecessaryActionException;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
        adminDto.setRole(Role.GUEST);
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

    public boolean makeAdmin(String userId) {
        log.debug("Start change user role with id {}", userId);
        Optional<Admin> findUser = adminRepository.findById(userId);
        if (findUser.isPresent()) {
            Admin user = findUser.get();
            log.debug("user with id exist");
            if (user.getRole().equals(Role.ADMIN)) {
                log.debug("Unnecessary actions, this user {} already admin", user);
                throw new UnnecessaryActionException("User with id " + user.getId() + " already admin");
            } else {
                user.setRole(Role.ADMIN);
                adminRepository.save(user);
                log.debug("Role updated on user with id {}", user.getId());
                return true;
            }
        } else {
            log.debug("User with id {} not found", userId);
            throw new ResourceNotFoundException("User with id " + userId + " not found");
        }
    }

    public boolean makeTravelAgent(String userId) {log.debug("Start change user role with id {}", userId);
        Optional<Admin> findUser = adminRepository.findById(userId);
        if (findUser.isPresent()) {
            Admin user = findUser.get();
            log.debug("user with id exist");
            if (user.getRole().equals(Role.TRAVELAGENT)) {
                log.debug("Unnecessary actions, this user {} already TravelAgent", user);
                throw new UnnecessaryActionException("User with id " + user.getId() + " already TravelAgent");
            } else {
                user.setRole(Role.TRAVELAGENT);
                adminRepository.save(user);
                log.debug("Role updated on user with id {}", user.getId());
                return true;
            }
        } else {
            log.debug("User with id {} not found", userId);
            throw new ResourceNotFoundException("User with id " + userId + " not found");
        }

    }
}
