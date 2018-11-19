package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.entity.TravelAgency;

public class TravelAgencyConverter {

    public TravelAgency convert(TravelAgencyDto travelAgencyDto){
        TravelAgency travelAgency= new TravelAgency();
        return travelAgency;
    }

    public TravelAgencyDto convert(TravelAgency travelAgency){
        TravelAgencyDto travelAgencyDto= new TravelAgencyDto();
        return travelAgencyDto;
    }
    
}
