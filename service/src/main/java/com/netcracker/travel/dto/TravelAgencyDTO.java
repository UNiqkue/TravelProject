package com.netcracker.travel.dto;

import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.TravelAgent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelAgencyDTO {

    private String id;

    private String name;

    private List<Tour> tours;

    private List<TravelAgent> travelAgents;

}
