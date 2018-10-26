package dao;

import dao.abstracts.BaseEntity;
import dao.enums.TypeTour;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

public class Tour extends BaseEntity {

//    private UUID id;
    private String name;
    private String description;
    private Set<TypeTour> type;
    private String country;
    private Date startDate;
    private Date endDate;
    private TravelAgency travelAgency;
    private double price;

    public Tour(){}

//    @Override
//    public UUID getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(UUID id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TypeTour> getType() {
        return type;
    }

    public void setType(Set<TypeTour> type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TravelAgency getTravelAgency() {
        return travelAgency;
    }

    public void setTravelAgency(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
