package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.organization.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
