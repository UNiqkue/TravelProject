package com.netcracker.travel.converter;

import com.netcracker.travel.dto.AdminDTO;
import com.netcracker.travel.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AdminMapper {
    @Mappings({
            @Mapping(target = "id", source = "admin.id"),
            @Mapping(target = "firstName", source = "admin.firstName"),
            @Mapping(target = "lastName", source = "admin.lastName"),
            @Mapping(target = "username", source = "admin.username"),
            @Mapping(target = "password", source = "admin.password"),
            @Mapping(target = "email", source = "admin.email"),
            @Mapping(target = "activationCode", source = "admin.activationCode"),
            @Mapping(target="role", source = "admin.role")})
    AdminDTO adminToAdminDTO(Admin admin);

    @Mappings({
            @Mapping(target = "id", source = "adminDTO.id"),
            @Mapping(target = "firstName", source = "adminDTO.firstName"),
            @Mapping(target = "lastName", source = "adminDTO.lastName"),
            @Mapping(target = "username", source = "adminDTO.username"),
            @Mapping(target = "password", source = "adminDTO.password"),
            @Mapping(target = "email", source = "adminDTO.email"),
            @Mapping(target = "activationCode", source = "adminDTO.activationCode"),
            @Mapping(target="role", source = "adminDTO.role")})
    Admin adminDTOtoAdmin(AdminDTO adminDTO);

}
