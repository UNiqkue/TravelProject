package com.netcracker.travel.converter;

import com.netcracker.travel.domain.TravelAgency;
import com.netcracker.travel.dto.TravelAgencyDTO;
import org.springframework.stereotype.Component;

@Component
public class TravelAgencyConverter {

    public TravelAgency convert(TravelAgencyDTO travelAgencyDto) {
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setId(travelAgencyDto.getId());
        travelAgency.setName(travelAgencyDto.getName());
     /*   travelAgency.setTours(travelAgencyDto.getTours());
        travelAgency.setTravelAgents(travelAgencyDto.getTravelAgents());*/
        return travelAgency;
    }

    public TravelAgencyDTO convert(TravelAgency travelAgency) {
        TravelAgencyDTO travelAgencyDto = new TravelAgencyDTO();
        travelAgencyDto.setId(travelAgency.getId());
        travelAgencyDto.setName(travelAgency.getName());
     /*   travelAgencyDto.setTours(travelAgency.getTours());
        travelAgencyDto.setTravelAgents(travelAgency.getTravelAgents());*/
        return travelAgencyDto;
    }

}
