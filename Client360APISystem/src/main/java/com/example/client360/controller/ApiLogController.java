package com.example.client360.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.client360.entity.ApiLog;
import com.example.client360.service.ApiLogService;

@RestController
@RequestMapping("/api/logs")
public class ApiLogController {

    private final ApiLogService service;

    public ApiLogController(ApiLogService service) {
        this.service = service;
    }

    @GetMapping
    public List<ApiLog> getAll() {
        return service.getAllLogs();
    }

    @PostMapping
    public ApiLog create(@RequestBody ApiLog log) {
        return service.createLog(log);
    }
}
