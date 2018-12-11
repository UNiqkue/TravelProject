package com.netcracker.travel.dto;

import com.netcracker.travel.domain.Customer;
import com.netcracker.travel.domain.TravelAgency;
import com.netcracker.travel.domain.enumeration.TypeTour;

import java.sql.Date;
import java.util.Objects;

public class TourDto {

    private String id;
    private String name;
    private String description;
    private Double price;
    private TypeTour type;
    private String country;
    private Date startDate;
    private Date endDate;
    private TravelAgency travelAgency;
    private Customer customer;
    private boolean free;

    public TourDto() {
    }

    public TourDto(String id, String name, String description, Double price, TypeTour type, String country, Date startDate, Date endDate, TravelAgency travelAgency, Customer customer, boolean free) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.travelAgency = travelAgency;
        this.customer = customer;
        this.free = free;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeTour getType() {
        return type;
    }

    public void setType(String type) {
        this.type = TypeTour.valueOf(type);
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        TourDto tourDto = (TourDto) o;
        return Objects.equals(getId(), tourDto.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TourDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", country='" + country + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", travelAgencyId='" + travelAgency + '\'' +
                ", customerId=" + customer +
                ", free=" + free +
                '}';
    }
}
