package dao;

import dao.abstracts.BaseEntity;

public class TravelAgency extends BaseEntity {

    private Long id;
    private String name;
    private String address;
    private Integer countTour;

    public TravelAgency(){}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
}
