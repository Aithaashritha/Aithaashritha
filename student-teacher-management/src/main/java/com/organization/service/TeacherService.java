package com.organization.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.organization.entity.Teacher;
import com.organization.repository.TeacherRepository;

@Service
public class TeacherService {

    private final TeacherRepository repo;

    @Autowired
    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public List<Teacher> getAllTeachers() {
        return repo.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return repo.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteTeacher(Long id) {
        repo.deleteById(id);
        return "Teacher deleted with ID: " + id;
    }
}
