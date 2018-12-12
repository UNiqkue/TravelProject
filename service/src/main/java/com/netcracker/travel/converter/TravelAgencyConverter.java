package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.domain.TravelAgency;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TravelAgencyConverter {

    public TravelAgency convert(TravelAgencyDto travelAgencyDto) {
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setId(travelAgencyDto.getId().toString());
        travelAgency.setName(travelAgencyDto.getName());
     /*   travelAgency.setTours(travelAgencyDto.getTours());
        travelAgency.setTravelAgents(travelAgencyDto.getTravelAgents());*/
        return travelAgency;
    }

    public TravelAgencyDto convert(TravelAgency travelAgency) {
        TravelAgencyDto travelAgencyDto = new TravelAgencyDto();
        travelAgencyDto.setId(UUID.fromString(travelAgency.getId()));
        travelAgencyDto.setName(travelAgency.getName());
     /*   travelAgencyDto.setTours(travelAgency.getTours());
        travelAgencyDto.setTravelAgents(travelAgency.getTravelAgents());*/
        return travelAgencyDto;
    }

}
