package com.organization.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.organization.entity.Student;
import com.organization.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    // ✅ Manual constructor injection (Lombok would normally generate this)
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
}
