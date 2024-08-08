package com.study.eodini.user.controller;

import com.study.eodini.user.domain.UserEntity;
import com.study.eodini.user.domain.UserValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Boolean existsByEmail(String email);
    Optional<UserValue> findByName(String name);
    Optional<UserValue> findByEmail(String email);
}
