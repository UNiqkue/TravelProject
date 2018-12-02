package com.netcracker.travel.converter;

import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.entity.Admin;

public class AdminConverter {

<<<<<<< HEAD
    public Admin convert(AdminDto adminDto) {
        Admin admin = new Admin();
=======
    public Admin convert(AdminDto adminDto){
        Admin admin= new Admin();
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
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

<<<<<<< HEAD
    public AdminDto convert(Admin admin) {
        AdminDto adminDto = new AdminDto();
=======
    public AdminDto convert(Admin admin){
       AdminDto adminDto = new AdminDto();
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
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
