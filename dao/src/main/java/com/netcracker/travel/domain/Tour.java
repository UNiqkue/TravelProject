package com.netcracker.travel.domain;

import com.netcracker.travel.domain.enumeration.TypeTour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tour")
public class Tour extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private TypeTour type;

    @Column(name = "country")
    private String country;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "travel_agency_id")
    private TravelAgency travelAgency;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "free")
    private boolean free;

}
