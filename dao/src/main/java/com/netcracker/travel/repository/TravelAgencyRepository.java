package com.netcracker.travel.repository;

import com.netcracker.travel.entity.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TravelAgencyRepository extends JpaRepository<TravelAgency, UUID> {
    List<TravelAgency> findByName(String name);
}
