package com.netcracker.travel.entity;

import com.netcracker.travel.entity.enumeration.Role;

import java.util.Objects;
import java.util.UUID;

<<<<<<< HEAD
public class TravelAgent extends User {
=======
public class TravelAgent extends User{
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

    private String phoneNumber;
    private String position;
    private UUID travelAgencyId;

<<<<<<< HEAD
    public TravelAgent() {
    }
=======
    public TravelAgent(){ }
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

    @Override
    public void setRole(Role role) {
        super.setRole(Role.TRAVELAGENT);
    }

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

    public void setTravelAgencyId(UUID travelAgencyId) {
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
