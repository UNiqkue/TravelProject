package com.netcracker.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.travel.entity.Tour;
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

    @JsonIgnore
    private List<Tour> tours;

}
