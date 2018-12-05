package com.netcracker.travel.repository;

import com.netcracker.travel.entity.TravelAgency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TravelAgencyRepository extends CrudRepository<TravelAgency, UUID> {
    List<TravelAgency> findByName(String name);
}
