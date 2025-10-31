package com.example.teacherstudent.service;

import com.example.teacherstudent.entity.Teacher;
import com.example.teacherstudent.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setName(updatedTeacher.getName());
                    teacher.setEmail(updatedTeacher.getEmail());
                    return teacherRepository.save(teacher);
                })
                .orElse(null);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
