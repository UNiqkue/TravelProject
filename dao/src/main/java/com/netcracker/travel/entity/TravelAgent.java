package com.netcracker.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "travel_agent")
public class TravelAgent extends Admin {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "travel_agency_id")
    private TravelAgency travelAgency;

}
