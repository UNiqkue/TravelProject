package com.netcracker.travel.converter;

import com.netcracker.travel.domain.TravelAgency;
import com.netcracker.travel.dto.TravelAgencyDto;

import java.util.UUID;

public class TravelAgencyConverter {

    public TravelAgency convert(TravelAgencyDto travelAgencyDto) {
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setId(travelAgencyDto.getId().toString());
        travelAgency.setName(travelAgencyDto.getName());
        travelAgency.setCountTour(travelAgencyDto.getCountTour());
        travelAgency.setCountTravelAgent(travelAgencyDto.getCountTravelAgent());
        return travelAgency;
    }

    public TravelAgencyDto convert(TravelAgency travelAgency) {
        TravelAgencyDto travelAgencyDto = new TravelAgencyDto();
        travelAgencyDto.setId(UUID.fromString(travelAgency.getId().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5")));
        travelAgencyDto.setName(travelAgency.getName());
        travelAgencyDto.setCountTour(travelAgency.getCountTour());
        travelAgencyDto.setCountTravelAgent(travelAgency.getCountTravelAgent());
        return travelAgencyDto;
    }

}
