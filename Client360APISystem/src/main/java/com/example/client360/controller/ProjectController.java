package com.example.client360.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.client360.entity.Project;
import com.example.client360.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return service.getProjectById(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return service.createProject(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        return service.updateProject(id, updatedProject);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
        return "Project with ID " + id + " deleted successfully!";
    }
}
