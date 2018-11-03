package entity;

import java.util.Objects;

public class TravelAgent extends User{

    private String phoneNumber;
    private String position;
    private TravelAgency travelAgency;

    public TravelAgent(){ }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TravelAgency getTravelAgency() {
        return travelAgency;
    }

    public void setTravelAgency(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TravelAgent that = (TravelAgent) o;
        return Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getPosition(), that.getPosition()) &&
                Objects.equals(getTravelAgency(), that.getTravelAgency());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPhoneNumber(), getPosition(), getTravelAgency());
    }

    @Override
    public String toString() {
        return "TravelAgent{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", travelAgency=" + travelAgency +
                '}';
    }
}
