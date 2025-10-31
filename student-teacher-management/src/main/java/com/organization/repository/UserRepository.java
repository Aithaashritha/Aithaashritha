package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.organization.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
