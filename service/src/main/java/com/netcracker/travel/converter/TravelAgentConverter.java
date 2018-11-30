package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.entity.TravelAgent;

public class TravelAgentConverter {

    public TravelAgent convert(TravelAgentDto travelAgentDto){
        TravelAgent travelAgent= new TravelAgent();
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
        return travelAgent;
    }

    public TravelAgentDto convert(TravelAgent travelAgent){
        TravelAgentDto travelAgentDto= new TravelAgentDto();
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
        return travelAgentDto;
    }
}
