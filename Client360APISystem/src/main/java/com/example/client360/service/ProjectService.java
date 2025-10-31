package com.example.client360.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.client360.entity.Project;
import com.example.client360.Repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    public Project getProjectById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project createProject(Project project) {
        return repo.save(project);
    }

    public Project updateProject(Long id, Project updatedProject) {
        Project existing = getProjectById(id);
        existing.setProjectName(updatedProject.getProjectName());
        existing.setStartDate(updatedProject.getStartDate());
        existing.setEndDate(updatedProject.getEndDate());
        existing.setStatus(updatedProject.getStatus());
        existing.setClient(updatedProject.getClient());
        return repo.save(existing);
    }

    public void deleteProject(Long id) {
        repo.deleteById(id);
    }
}
