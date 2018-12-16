package com.netcracker.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "travel_agency")
public class TravelAgency extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "travelAgency")
    private List<TravelAgent> travelAgents;

    @OneToMany(mappedBy = "travelAgency")
    private List<Tour> tours;

}
