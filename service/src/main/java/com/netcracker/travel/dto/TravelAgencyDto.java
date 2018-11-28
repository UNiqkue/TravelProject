package com.netcracker.travel.dto;

import java.util.Objects;
import java.util.UUID;

public class TravelAgencyDto {

    private UUID id;
    private String name;
    private Integer countTour;
    private Integer countTravelAgent;

    public TravelAgencyDto(){}

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

    public Integer getCountTour() {
        return countTour;
    }

    public void setCountTour(Integer countTour) {
        this.countTour = countTour;
    }

    public Integer getCountTravelAgent() {
        return countTravelAgent;
    }

    public void setCountTravelAgent(Integer countTravelAgent) {
        this.countTravelAgent = countTravelAgent;
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
                ", name='" + name + '\'' +
                ", countTour=" + countTour +
                ", countTravelAgent=" + countTravelAgent +
                '}';
    }
}
