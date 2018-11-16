package com.netcracker.travel.entity;

import java.util.Objects;
import java.util.UUID;

public class TravelAgent extends User{

    private String phoneNumber;
    private String position;
    private UUID travelAgencyId;

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

    public UUID getTravelAgencyId() {
        return travelAgencyId;
    }

    public void setTravelAgency(UUID travelAgencyId) {
        this.travelAgencyId = travelAgencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TravelAgent that = (TravelAgent) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TravelAgent{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", travelAgencyId=" + travelAgencyId +
                '}';
    }
}
