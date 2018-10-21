package dao;

import dao.abstracts.BaseEntity;
import dao.enums.TypeTour;

import java.sql.Date;
import java.util.Set;

public class Tour extends BaseEntity {

    private Long id;
    private String name;
    private String description;
    private Set<TypeTour> type;
    private String country;
    private Date startDate;
    private Date endDate;
    private TravelAgency travelAgency;
    private double price;
    private Integer countCustomer;

    public Tour(){}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getCountCustomer() {
        return countCustomer;
    }

    public void setCountCustomer(Integer countCustomer) {
        this.countCustomer = countCustomer;
    }
}
