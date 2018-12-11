package com.netcracker.travel.domain;

import com.netcracker.travel.domain.abstracts.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "travel_agency")
public class TravelAgency extends BaseEntity {

    @Column(name = "name")
    private String name;
  //  @OneToMany(mappedBy = "travel_agency", fetch = FetchType.EAGER)
 //   private List<Tour> tours;

  //  @Access(AccessType.PROPERTY)
  //  @ElementCollection(targetClass=TravelAgent.class)
  //  private List<TravelAgent> travelAgents;

    public TravelAgency() {
    }

    public TravelAgency(String id, String name, List<Tour> tours, List<TravelAgent> travelAgents) {
        super(id);
        this.name = name;
      //  this.tours = tours;
       // this.travelAgents = travelAgents;
    }

  /*  public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }*/


  /*  @OneToMany(/*targetEntity = TravelAgent.class,*/
    /*mappedBy = "travel_agency", cascade = CascadeType.ALL/*
    , fetch = FetchType.EAGER*//*)

    public List<TravelAgent> getTravelAgents() {
        return travelAgents;
    }*/

  /*  public void setTravelAgents(List<TravelAgent> travelAgents) {
        this.travelAgents = travelAgents;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgency that = (TravelAgency) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
             //   ", tours=" + tours +
             //   ", travelAgents=" + travelAgents +
                '}';
    }
}
