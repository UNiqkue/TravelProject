package dao.entity;

import dao.entity.abstracts.BaseEntity;
import dao.entity.enums.TypeTour;

import java.sql.Date;
import java.util.Set;

public class Tour extends BaseEntity {

    private String name;
    private String description;
    private Double price;
    private Set<TypeTour> type;
    private String country;
    private Date startDate;
    private Date endDate;
    private TravelAgency travelAgency;

    public Tour(){}

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
