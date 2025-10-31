package com.example.mall.controller;

import com.example.mall.entity.Mall;
import com.example.mall.service.MallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/malls")
public class MallController {

    private final MallService service;

    public MallController(MallService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mall> getAll() {
        return service.getAllMalls();
    }

    @GetMapping("/{id}")
    public Mall getById(@PathVariable Long id) {
        return service.getMallById(id);
    }

    @PostMapping
    public Mall create(@RequestBody Mall mall) {
        return service.createMall(mall);
    }

    @PutMapping("/{id}")
    public Mall update(@PathVariable Long id, @RequestBody Mall mall) {
        return service.updateMall(id, mall);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteMall(id);
    }
}
