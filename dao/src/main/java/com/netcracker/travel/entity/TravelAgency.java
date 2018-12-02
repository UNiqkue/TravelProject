package com.netcracker.travel.entity;

import com.netcracker.travel.entity.abstracts.BaseEntity;

import java.util.Objects;
import java.util.UUID;

public class TravelAgency extends BaseEntity {

    private String name;
    private Integer countTour;
    private Integer countTravelAgent;

    public TravelAgency() {
<<<<<<< HEAD
=======
    }

    public String getName() {
        return name;
>>>>>>> task3
    }

    public TravelAgency(UUID id, String name, Integer countTour, Integer countTravelAgent) {
        super(id);
        this.name = name;
        this.countTour = countTour;
        this.countTravelAgent = countTravelAgent;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

=======
>>>>>>> task3
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
                ", countTour=" + countTour +
                ", countTravelAgent=" + countTravelAgent +
                '}';
    }

}
