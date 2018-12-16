package com.netcracker.travel.dto;

import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.entity.enumeration.TypeTour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourDTO {

    private String id;

    private String name;

    private String description;

    private String country;

    private Date startDate;

    private Date endDate;

    private Double price;

    private TypeTour type;

    private boolean free;

}
