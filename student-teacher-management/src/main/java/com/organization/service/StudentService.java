package com.organization.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.organization.entity.Student;
import com.organization.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    // ✅ Manual constructor injection (no Lombok)
    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteStudent(Long id) {
        repo.deleteById(id);
        return "Student deleted with ID: " + id;
    }
}
