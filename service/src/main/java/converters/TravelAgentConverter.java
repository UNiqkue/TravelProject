package converters;

import dto.TravelAgentDto;
import entity.TravelAgency;
import entity.TravelAgent;

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

        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setName(travelAgentDto.getNameTravelAgency());
        travelAgent.setTravelAgency(travelAgency);

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

        if (travelAgent.getTravelAgency() != null) {
            travelAgentDto.setNameTravelAgency(travelAgent.getTravelAgency().getName());
        }



        return travelAgentDto;
    }
}
