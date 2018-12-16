package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.entity.enumeration.TypeTour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TourRepository extends CrudRepository<Tour, String> {
    List<Tour> findByName(String name);

    List<Tour> findByType(TypeTour type);

    List<Tour> findByCountry(String country);

    List<Tour> findByStartDate(Date startDate);

    List<Tour> findByEndDate(Date endDate);

    Tour getById(String id);

    List<Tour> findByTravelAgency(TravelAgency travelAgency);

    List<Tour> findAllByCustomer(Customer customer);
}
