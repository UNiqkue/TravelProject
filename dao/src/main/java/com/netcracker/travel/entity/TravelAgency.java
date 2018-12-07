package com.netcracker.travel.entity;

import com.netcracker.travel.entity.abstracts.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "travel_agency")
public class TravelAgency extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "count_tour")
    private Integer countTour;
    @Column(name = "count_travel_agent")
    private Integer countTravelAgent;

    public TravelAgency() {
    }

    public TravelAgency(UUID id, String name, Integer countTour, Integer countTravelAgent) {
        super(id);
        this.name = name;
        this.countTour = countTour;
        this.countTravelAgent = countTravelAgent;
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
