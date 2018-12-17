package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {
    Optional<Admin> findByUsername(String username);

    Optional<Admin> findById(String id);
}
