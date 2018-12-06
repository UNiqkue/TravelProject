package com.netcracker.travel.repository;

import com.netcracker.travel.entity.TravelAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TravelAgentRepository extends JpaRepository<TravelAgent, UUID> {
    TravelAgent findByUsername(String username);
}
