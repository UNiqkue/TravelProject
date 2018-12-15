package com.netcracker.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travel_agent")
public class TravelAgent extends User {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "travel_agency_id")
    private TravelAgency travelAgency;

}
