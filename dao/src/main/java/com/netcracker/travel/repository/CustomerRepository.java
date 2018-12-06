package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findByUsername(String username);
}
