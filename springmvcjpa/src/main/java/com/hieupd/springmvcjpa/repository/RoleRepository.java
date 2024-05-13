package com.hieupd.springmvcjpa.repository;

import com.hieupd.springmvcjpa.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
