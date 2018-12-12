package com.netcracker.travel.repository;

import com.netcracker.travel.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TourRepository extends CrudRepository<Tour, String> {
    List<Tour> findByName(String name);

    List<Tour> findByType(String type);

    List<Tour> findByCountry(String country);

    List<Tour> findByStartDate(Date startDate);

    List<Tour> findByEndDate(Date endDate);

    Tour getById(String id);
  /*  List<Tour> findByTravelAgencyId(UUID id);
    List<Tour> findAllByCustomerId(UUID id);*/
}
