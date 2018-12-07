package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminRepository extends CrudRepository<Admin, UUID> {
    Admin findByUsername(String username);
}
