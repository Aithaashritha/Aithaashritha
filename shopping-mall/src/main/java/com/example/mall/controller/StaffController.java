package com.example.mall.controller;

import com.example.mall.entity.Staff;
import com.example.mall.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping
    public List<Staff> getAll() {
        return service.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable Long id) {
        return service.getStaffById(id);
    }

    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return service.createStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff update(@PathVariable Long id, @RequestBody Staff staff) {
        return service.updateStaff(id, staff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStaff(id);
    }
}
