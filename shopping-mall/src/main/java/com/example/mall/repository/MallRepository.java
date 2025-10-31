package com.example.mall.repository;

import com.example.mall.entity.Mall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MallRepository extends JpaRepository<Mall, Long> {
}
