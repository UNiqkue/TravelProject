package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgencyDto;
<<<<<<< HEAD
=======
import com.netcracker.travel.entity.Address;
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
import com.netcracker.travel.entity.TravelAgency;

public class TravelAgencyConverter {

<<<<<<< HEAD
    public TravelAgency convert(TravelAgencyDto travelAgencyDto) {
        TravelAgency travelAgency = new TravelAgency();
=======
    public TravelAgency convert(TravelAgencyDto travelAgencyDto){
        TravelAgency travelAgency= new TravelAgency();
        
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
        travelAgency.setId(travelAgencyDto.getId());
        travelAgency.setName(travelAgencyDto.getName());
        travelAgency.setCountTour(travelAgencyDto.getCountTour());
        travelAgency.setCountTravelAgent(travelAgencyDto.getCountTravelAgent());
<<<<<<< HEAD
        return travelAgency;
    }

    public TravelAgencyDto convert(TravelAgency travelAgency) {
        TravelAgencyDto travelAgencyDto = new TravelAgencyDto();
=======
        
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
        
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
        travelAgencyDto.setId(travelAgency.getId());
        travelAgencyDto.setName(travelAgency.getName());
        travelAgencyDto.setCountTour(travelAgency.getCountTour());
        travelAgencyDto.setCountTravelAgent(travelAgency.getCountTravelAgent());
<<<<<<< HEAD
        return travelAgencyDto;
    }

=======

        if (travelAgency.getAddress() != null) {
            travelAgencyDto.setCountry(travelAgency.getAddress().getCountry());
            travelAgencyDto.setCity(travelAgency.getAddress().getCity());
            travelAgencyDto.setStreet(travelAgency.getAddress().getStreet());
            travelAgencyDto.setNumberHouse(travelAgency.getAddress().getNumberHouse());
            travelAgencyDto.setNumberRoom(travelAgency.getAddress().getNumberRoom());
        }

        return travelAgencyDto;
    }
    
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
}
