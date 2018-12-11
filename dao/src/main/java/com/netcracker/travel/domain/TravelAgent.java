package com.netcracker.travel.domain;

import com.netcracker.travel.domain.abstracts.User;
import com.netcracker.travel.domain.enumeration.Role;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "travel_agent")
public class TravelAgent extends User {

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "position")
    private String position;
    @Column(name = "travel_agency_id")
    private UUID travelAgencyId;

    public TravelAgent() {
    }

    public TravelAgent(String id, String firstName, String lastName, String username, String password, String email, String activationCode, String phoneNumber, String position, UUID travelAgencyId) {
        super(id, firstName, lastName, username, password, email, activationCode);
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.travelAgencyId = travelAgencyId;
    }

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
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", activationCode='" + getActivationCode() + '\'' +
                ", role=" + getRole() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", travelAgencyId=" + travelAgencyId +
                '}';
    }

}