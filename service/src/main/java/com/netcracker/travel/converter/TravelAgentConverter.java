package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.entity.TravelAgent;

public class TravelAgentConverter {

<<<<<<< HEAD
    public TravelAgent convert(TravelAgentDto travelAgentDto) {
        TravelAgent travelAgent = new TravelAgent();
=======
    public TravelAgent convert(TravelAgentDto travelAgentDto){
        TravelAgent travelAgent= new TravelAgent();
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
        travelAgent.setId(travelAgentDto.getId());
        travelAgent.setFirstName(travelAgentDto.getFirstName());
        travelAgent.setLastName(travelAgentDto.getLastName());
        travelAgent.setUsername(travelAgentDto.getUsername());
        travelAgent.setPassword(travelAgentDto.getPassword());
        travelAgent.setEmail(travelAgentDto.getEmail());
        travelAgent.setActivationCode(travelAgentDto.getActivationCode());
        travelAgent.setPhoneNumber(travelAgentDto.getPhoneNumber());
        travelAgent.setPosition(travelAgentDto.getPosition());
        travelAgent.setTravelAgencyId(travelAgentDto.getTravelAgencyId());
<<<<<<< HEAD
        return travelAgent;
    }

    public TravelAgentDto convert(TravelAgent travelAgent) {
        TravelAgentDto travelAgentDto = new TravelAgentDto();
=======

        return travelAgent;
    }

    public TravelAgentDto convert(TravelAgent travelAgent){
        TravelAgentDto travelAgentDto= new TravelAgentDto();
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
        travelAgentDto.setId(travelAgent.getId());
        travelAgentDto.setFirstName(travelAgent.getFirstName());
        travelAgentDto.setLastName(travelAgent.getLastName());
        travelAgentDto.setUsername(travelAgent.getUsername());
        travelAgentDto.setPassword(travelAgent.getPassword());
        travelAgentDto.setEmail(travelAgent.getEmail());
        travelAgentDto.setActivationCode(travelAgent.getActivationCode());
        travelAgentDto.setPhoneNumber(travelAgent.getPhoneNumber());
        travelAgentDto.setPosition(travelAgent.getPosition());
        travelAgentDto.setTravelAgencyId(travelAgent.getTravelAgencyId());
<<<<<<< HEAD
=======

>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
        return travelAgentDto;
    }
}
