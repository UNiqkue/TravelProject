package com.netcracker.travel.dto;

import com.netcracker.travel.domain.Customer;
import com.netcracker.travel.domain.TravelAgency;
import com.netcracker.travel.domain.enumeration.TypeTour;
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

    private TravelAgency travelAgency;

    private Customer customer;

    private boolean free;

}
