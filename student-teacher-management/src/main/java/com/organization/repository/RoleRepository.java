package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.organization.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
