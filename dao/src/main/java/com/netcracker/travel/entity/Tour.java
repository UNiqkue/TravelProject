package com.netcracker.travel.entity;

import com.netcracker.travel.entity.abstracts.BaseEntity;
import com.netcracker.travel.entity.enumeration.TypeTour;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tour")
public class Tour extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeTour type;
    @Column(name = "country")
    private String country;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "travel_agency", nullable = false)
    @Column(name = "travel_agency_id")
    private UUID travelAgencyId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer", nullable = false)
    @Column(name = "customer_id")
    private UUID customerId;
    @Column(name = "free")
    private boolean free;

    public Tour() {
    }

    public Tour(UUID id, String name, String description, Double price, TypeTour type, String country, Date startDate, Date endDate, UUID travelAgencyId, UUID customerId, boolean free) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.travelAgencyId = travelAgencyId;
        this.customerId = customerId;
        this.free = free;
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

    public TypeTour getType() {
        return type;
    }

    public void setType(TypeTour type) {
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
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", country='" + country + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", travelAgencyId=" + travelAgencyId +
                ", customerId=" + customerId +
                ", free=" + free +
                '}';
    }

}
