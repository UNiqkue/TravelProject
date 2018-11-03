package entity;

import entity.abstracts.BaseEntity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgency that = (TravelAgency) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getCountTour(), that.getCountTour()) &&
                Objects.equals(getCountTravelAgent(), that.getCountTravelAgent());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAddress(), getCountTour(), getCountTravelAgent());
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", countTour=" + countTour +
                ", countTravelAgent=" + countTravelAgent +
                '}';
    }
}
