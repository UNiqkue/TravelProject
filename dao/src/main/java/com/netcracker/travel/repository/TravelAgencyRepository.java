package com.netcracker.travel.repository;

import com.netcracker.travel.entity.TravelAgency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelAgencyRepository extends CrudRepository<TravelAgency, String> {
    List<TravelAgency> findByName(String name);

    TravelAgency getById(String id);
}
