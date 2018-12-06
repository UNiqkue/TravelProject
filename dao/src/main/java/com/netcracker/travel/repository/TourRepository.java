package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface TourRepository extends JpaRepository<Tour, UUID> {
    List<Tour> findByName(String name);
    List<Tour> findByType(String type);
    List<Tour> findByCountry(String country);
    List<Tour> findByDate(Date startDate, Date endDate);
    Tour getById(UUID id);
    List<Tour> findByTravelAgencyId(UUID id);
    List<Tour> findAllByCustomerId(UUID id);
}
