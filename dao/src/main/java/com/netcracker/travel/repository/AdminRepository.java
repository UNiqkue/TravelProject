package com.netcracker.travel.repository;

import com.netcracker.travel.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {
    Admin findByUsername(String username);
}
