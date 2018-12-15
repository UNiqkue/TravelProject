package com.netcracker.travel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public TravelAgency() {
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public List<TravelAgent> getTravelAgents() {
        return travelAgents;
    }

    public void setTravelAgents(List<TravelAgent> travelAgents) {
        this.travelAgents = travelAgents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgency that = (TravelAgency) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", tours=" + tours +
                ", travelAgents=" + travelAgents +
                '}';
    }
}
