package com.netcracker.travel.converter;

import com.netcracker.travel.domain.Admin;
import com.netcracker.travel.dto.AdminDTO;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {

    public Admin convert(AdminDTO adminDto) {
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setEmail(adminDto.getEmail());
        admin.setActivationCode(adminDto.getActivationCode());
        admin.setRole(adminDto.getRole());
        return admin;
    }

    public AdminDTO convert(Admin admin) {
        AdminDTO adminDto = new AdminDTO();
        adminDto.setId(admin.getId());
        adminDto.setFirstName(admin.getFirstName());
        adminDto.setLastName(admin.getLastName());
        adminDto.setUsername(admin.getUsername());
        adminDto.setPassword(admin.getPassword());
        adminDto.setEmail(admin.getEmail());
        adminDto.setActivationCode(admin.getActivationCode());
        adminDto.setRole(admin.getRole());
        return adminDto;
    }
}
