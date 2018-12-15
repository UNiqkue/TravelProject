package com.netcracker.travel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travel_agency")
public class TravelAgency extends BaseEntity {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "travelAgency")
    private List<TravelAgent> travelAgents;

    @JsonIgnore
    @OneToMany(mappedBy = "travelAgency")
    private List<Tour> tours;

}
