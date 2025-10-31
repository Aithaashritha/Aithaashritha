package com.example.teacherstudent.repository;

import com.example.teacherstudent.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
