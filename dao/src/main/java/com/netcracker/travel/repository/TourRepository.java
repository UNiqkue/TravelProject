package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface TourRepository extends CrudRepository<Tour, UUID> {
    List<Tour> findByName(String name);
    List<Tour> findByType(String type);
    List<Tour> findByCountry(String country);
    List<Tour> findByDate(Date startDate, Date endDate);
    Tour getById(UUID id);
    List<Tour> findByTravelAgencyId(UUID id);
    List<Tour> findAllByCustomerId(UUID id);
}
