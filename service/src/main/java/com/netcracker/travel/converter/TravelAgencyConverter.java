package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.entity.TravelAgency;

public class TravelAgencyConverter {

    public TravelAgency convert(TravelAgencyDto travelAgencyDto){
        TravelAgency travelAgency= new TravelAgency();
        
        travelAgency.setId(travelAgencyDto.getId());
        travelAgency.setName(travelAgencyDto.getName());
        travelAgency.setCountTour(travelAgencyDto.getCountTour());
        travelAgency.setCountTravelAgent(travelAgencyDto.getCountTravelAgent());
        

        return travelAgency;
    }

    public TravelAgencyDto convert(TravelAgency travelAgency){
        TravelAgencyDto travelAgencyDto= new TravelAgencyDto();
        
        travelAgencyDto.setId(travelAgency.getId());
        travelAgencyDto.setName(travelAgency.getName());
        travelAgencyDto.setCountTour(travelAgency.getCountTour());
        travelAgencyDto.setCountTravelAgent(travelAgency.getCountTravelAgent());

        return travelAgencyDto;
    }
    
}
