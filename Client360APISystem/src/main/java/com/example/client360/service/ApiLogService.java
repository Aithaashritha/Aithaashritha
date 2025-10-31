package com.example.client360.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.client360.entity.ApiLog;
import com.example.client360.Repository.ApiLogRepository;

@Service
public class ApiLogService {

    private final ApiLogRepository repo;

    public ApiLogService(ApiLogRepository repo) {
        this.repo = repo;
    }

    public List<ApiLog> getAllLogs() {
        return repo.findAll();
    }

    public ApiLog createLog(ApiLog log) {
        return repo.save(log);
    }
}
