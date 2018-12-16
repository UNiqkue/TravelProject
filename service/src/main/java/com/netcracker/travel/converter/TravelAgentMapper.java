package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgentDTO;
import com.netcracker.travel.entity.TravelAgent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TravelAgentMapper {
    @Mappings({
            @Mapping(target = "id", source = "travelAgent.id"),
            @Mapping(target="firstName", source = "travelAgent.firstName"),
            @Mapping(target="lastName", source = "travelAgent.lastName"),
            @Mapping(target="username", source = "travelAgent.username"),
            @Mapping(target="password", source = "travelAgent.password"),
            @Mapping(target="email", source = "travelAgent.email"),
            @Mapping(target="activationCode", source = "travelAgent.activationCode"),
            @Mapping(target="phoneNumber", source = "travelAgent.phoneNumber"),
            @Mapping(target="position", source = "travelAgent.position"),
            @Mapping(target="role", source = "travelAgent.role")})
    TravelAgentDTO travelAgentToTravelAgentDTO(TravelAgent travelAgent);

    @Mappings({
            @Mapping(target = "id", source = "travelAgentDTO.id"),
            @Mapping(target="firstName", source = "travelAgentDTO.firstName"),
            @Mapping(target="lastName", source = "travelAgentDTO.lastName"),
            @Mapping(target="username", source = "travelAgentDTO.username"),
            @Mapping(target="password", source = "travelAgentDTO.password"),
            @Mapping(target="email", source = "travelAgentDTO.email"),
            @Mapping(target="activationCode", source = "travelAgentDTO.activationCode"),
            @Mapping(target="phoneNumber", source = "travelAgentDTO.phoneNumber"),
            @Mapping(target="position", source = "travelAgentDTO.position"),
            @Mapping(target="role", source = "travelAgentDTO.role")})
    TravelAgent travelAgentDTOtoTravelAgent(TravelAgentDTO travelAgentDTO);

}
