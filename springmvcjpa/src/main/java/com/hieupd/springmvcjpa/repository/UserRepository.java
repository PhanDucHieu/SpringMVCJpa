package com.hieupd.springmvcjpa.repository;

import com.hieupd.springmvcjpa.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUserName(String username);
}
