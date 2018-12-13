package com.netcracker.travel.repository;

import com.netcracker.travel.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
    Customer findByUsername(String username);

    Customer findById(String id);
}
