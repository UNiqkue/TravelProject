package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.entity.Address;
import com.netcracker.travel.entity.TravelAgency;

public class TravelAgencyConverter {

    public TravelAgency convert(TravelAgencyDto travelAgencyDto){
        TravelAgency travelAgency= new TravelAgency();
        
        travelAgency.setId(travelAgencyDto.getId());
        travelAgency.setName(travelAgencyDto.getName());
        travelAgency.setCountTour(travelAgencyDto.getCountTour());
        travelAgency.setCountTravelAgent(travelAgencyDto.getCountTravelAgent());
        
        Address address = new Address();
        address.setCountry(travelAgencyDto.getCountry());
        address.setCity(travelAgencyDto.getCity());
        address.setStreet(travelAgencyDto.getStreet());
        address.setNumberHouse(travelAgencyDto.getNumberHouse());
        address.setNumberRoom(travelAgencyDto.getNumberRoom());
        travelAgency.setAddress(address);
        

        return travelAgency;
    }

    public TravelAgencyDto convert(TravelAgency travelAgency){
        TravelAgencyDto travelAgencyDto= new TravelAgencyDto();
        
        travelAgencyDto.setId(travelAgency.getId());
        travelAgencyDto.setName(travelAgency.getName());
        travelAgencyDto.setCountTour(travelAgency.getCountTour());
        travelAgencyDto.setCountTravelAgent(travelAgency.getCountTravelAgent());

        if (travelAgency.getAddress() != null) {
            travelAgencyDto.setCountry(travelAgency.getAddress().getCountry());
            travelAgencyDto.setCity(travelAgency.getAddress().getCity());
            travelAgencyDto.setStreet(travelAgency.getAddress().getStreet());
            travelAgencyDto.setNumberHouse(travelAgency.getAddress().getNumberHouse());
            travelAgencyDto.setNumberRoom(travelAgency.getAddress().getNumberRoom());
        }

        return travelAgencyDto;
    }
    
}
