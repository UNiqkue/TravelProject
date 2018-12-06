package com.netcracker.travel.repository;

import com.netcracker.travel.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Admin findByUsername(String username);
}
