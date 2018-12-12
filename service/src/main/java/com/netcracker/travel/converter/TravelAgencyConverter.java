package com.netcracker.travel.converter;

import com.netcracker.travel.domain.TravelAgency;
import com.netcracker.travel.dto.TravelAgencyDto;
import org.springframework.stereotype.Component;

@Component
public class TravelAgencyConverter {

    public TravelAgency convert(TravelAgencyDto travelAgencyDto) {
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setId(travelAgencyDto.getId());
        travelAgency.setName(travelAgencyDto.getName());
     /*   travelAgency.setTours(travelAgencyDto.getTours());
        travelAgency.setTravelAgents(travelAgencyDto.getTravelAgents());*/
        return travelAgency;
    }

    public TravelAgencyDto convert(TravelAgency travelAgency) {
        TravelAgencyDto travelAgencyDto = new TravelAgencyDto();
        travelAgencyDto.setId(travelAgency.getId());
        travelAgencyDto.setName(travelAgency.getName());
     /*   travelAgencyDto.setTours(travelAgency.getTours());
        travelAgencyDto.setTravelAgents(travelAgency.getTravelAgents());*/
        return travelAgencyDto;
    }

}
