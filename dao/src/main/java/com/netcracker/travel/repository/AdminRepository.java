package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AdminRepository extends CrudRepository<Admin, UUID> {
    List<Admin> findAll();
    Admin findByUsername(String username);
}
