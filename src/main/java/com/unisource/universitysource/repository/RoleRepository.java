package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Role;
import com.unisource.universitysource.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
