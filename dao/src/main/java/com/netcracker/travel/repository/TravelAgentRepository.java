package com.netcracker.travel.repository;

import com.netcracker.travel.entity.TravelAgent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TravelAgentRepository extends CrudRepository<TravelAgent, UUID> {
    TravelAgent findByUsername(String username);
    List<TravelAgent> findAll();
}
