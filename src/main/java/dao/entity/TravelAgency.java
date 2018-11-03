package dao.entity;

import dao.entity.abstracts.BaseEntity;

import java.util.UUID;

public class TravelAgency extends BaseEntity {

    private String name;
    private String address;
    private Integer countTour;
    private Integer countTravelAgent;

    public TravelAgency(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
