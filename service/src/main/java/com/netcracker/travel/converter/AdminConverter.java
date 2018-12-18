package com.netcracker.travel.converter;

import com.netcracker.travel.domain.Admin;
import com.netcracker.travel.dto.AdminDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AdminConverter {

    public Admin convert(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setId(adminDto.getId().toString());
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setEmail(adminDto.getEmail());
        admin.setActivationCode(adminDto.getActivationCode());
        admin.setRole(adminDto.getRole());
        return admin;
    }

    public AdminDto convert(Admin admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(UUID.fromString(admin.getId().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5")));
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
