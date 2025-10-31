package com.example.convergenceintegration.controller;

import org.springframework.web.bind.annotation.*;
import com.example.convergenceintegration.entity.TargetSystem;
import com.example.convergenceintegration.service.TargetSystemService;

import java.util.List;

@RestController
@RequestMapping("/api/targets")
public class TargetSystemController {

    private final TargetSystemService service;

    // Explicit constructor injection
    public TargetSystemController(TargetSystemService service) {
        this.service = service;
    }

    @GetMapping
    public List<TargetSystem> getAll() {
        return service.getAllTargets();
    }

    @GetMapping("/{id}")
    public TargetSystem getById(@PathVariable Long id) {
        return service.getTargetById(id)
                .orElseThrow(() -> new RuntimeException("Target system not found"));
    }

    @PostMapping
    public TargetSystem create(@RequestBody TargetSystem target) {
        return service.createTarget(target);
    }

    @PutMapping("/{id}")
    public TargetSystem update(@PathVariable Long id, @RequestBody TargetSystem target) {
        return service.updateTarget(id, target);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteTarget(id);
        return "Deleted target system with id: " + id;
    }
}
