package com.netcracker.travel.dto;

import com.netcracker.travel.domain.Tour;
import com.netcracker.travel.domain.TravelAgent;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TravelAgencyDto {

    private UUID id;
    private String name;
    private List<Tour> tours;
    private List<TravelAgent> travelAgents;

    public TravelAgencyDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgencyDto that = (TravelAgencyDto) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TravelAgencyDto{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", tours=" + tours +
                ", travelAgents=" + travelAgents +
                '}';
    }
}
