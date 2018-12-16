package com.netcracker.travel.converter;

import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.entity.TravelAgent;
import com.netcracker.travel.dto.TourDTO;
import com.netcracker.travel.dto.TravelAgencyDTO;
import com.netcracker.travel.dto.TravelAgentDTO;
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

    Tour tourDTOtoTour(TourDTO tourDto);

    TourDTO tourToTourDTO(Tour tour);

    TravelAgent travelAgentDTOtoTravelAgent(TravelAgentDTO travelAgentDto);

    TravelAgentDTO travelAgentToTravelAgentDTO(TravelAgent travelAgent);
}
