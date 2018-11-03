package entity;

import entity.abstracts.BaseEntity;
import entity.enums.TypeTour;

import java.sql.Date;
import java.util.Objects;
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
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(getName(), tour.getName()) &&
                Objects.equals(getDescription(), tour.getDescription()) &&
                Objects.equals(getPrice(), tour.getPrice()) &&
                Objects.equals(getType(), tour.getType()) &&
                Objects.equals(getCountry(), tour.getCountry()) &&
                Objects.equals(getStartDate(), tour.getStartDate()) &&
                Objects.equals(getEndDate(), tour.getEndDate()) &&
                Objects.equals(getTravelAgency(), tour.getTravelAgency()) &&
                Objects.equals(getCustomer(), tour.getCustomer());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getDescription(), getPrice(), getType(), getCountry(), getStartDate(), getEndDate(), getTravelAgency(), getCustomer());
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
                ", travelAgency=" + travelAgency +
                ", customer=" + customer +
                '}';
    }
}
