package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Customer findByUsername(String username);
    List<Customer> findAll();
    Customer getById(UUID id);
}
