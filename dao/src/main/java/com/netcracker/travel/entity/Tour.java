package com.netcracker.travel.entity;

import com.netcracker.travel.entity.abstracts.BaseEntity;
import com.netcracker.travel.entity.enumeration.TypeTour;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Tour extends BaseEntity {

    private String name;
    private String description;
    private Double price;
    private Set<TypeTour> type;
    private String country;
    private Date startDate;
    private Date endDate;
    private UUID travelAgencyId;
    private UUID customerId;
    private boolean free;

    public Tour(){
    }

    public Tour(UUID id, String name, String description, Double price, Set<TypeTour> type, String country, Date startDate, Date endDate) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UUID getTravelAgencyId() {
        return travelAgencyId;
    }

    public void setTravelAgencyId(UUID travelAgencyId) {
        this.travelAgencyId = travelAgencyId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(getId(), tour.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Tour{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", country='" + country + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

}
