package com.example.mall.service;

import com.example.mall.entity.Mall;
import com.example.mall.repository.MallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallService {

    private final MallRepository repo;

    public MallService(MallRepository repo) {
        this.repo = repo;
    }

    public List<Mall> getAllMalls() {
        return repo.findAll();
    }

    public Mall getMallById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Mall createMall(Mall mall) {
        return repo.save(mall);
    }

    public Mall updateMall(Long id, Mall details) {
        Mall mall = repo.findById(id).orElse(null);
        if (mall != null) {
            mall.setName(details.getName());
            mall.setLocation(details.getLocation());
            mall.setContactNumber(details.getContactNumber());
            return repo.save(mall);
        }
        return null;
    }

    public void deleteMall(Long id) {
        repo.deleteById(id);
    }
}
