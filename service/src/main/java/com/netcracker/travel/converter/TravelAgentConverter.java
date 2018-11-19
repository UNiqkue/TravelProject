package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.entity.TravelAgent;

public class TravelAgentConverter {

    public TravelAgent convert(TravelAgentDto travelAgentDto){
        TravelAgent travelAgent= new TravelAgent();
        return travelAgent;
    }

    public TravelAgentDto convert(TravelAgent travelAgent){
        TravelAgentDto travelAgentDto= new TravelAgentDto();
        return travelAgentDto;
    }
}
