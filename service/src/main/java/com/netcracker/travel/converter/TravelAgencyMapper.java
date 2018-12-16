package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgencyDTO;
import com.netcracker.travel.entity.TravelAgency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TravelAgencyMapper {
    @Mappings({
            @Mapping(target = "id", source = "travelAgency.id"),
            @Mapping(target="name", source = "travelAgency.name")})
    TravelAgencyDTO travelAgencyToTravelAgencyDTO(TravelAgency travelAgency);

    @Mappings({
            @Mapping(target = "id", source = "travelAgencyDTO.id"),
            @Mapping(target="name", source = "travelAgencyDTO.name")})
    TravelAgency travelAgencyDTOtoTravelAgency(TravelAgencyDTO travelAgencyDTO);

}
