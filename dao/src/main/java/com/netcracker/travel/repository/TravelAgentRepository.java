package com.netcracker.travel.repository;

import com.netcracker.travel.entity.TravelAgent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelAgentRepository extends CrudRepository<TravelAgent, String> {
    TravelAgent findById(String id);

    TravelAgent findByUsername(String username);
}
