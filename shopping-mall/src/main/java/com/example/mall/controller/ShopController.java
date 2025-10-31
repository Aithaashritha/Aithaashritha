package com.example.mall.controller;

import com.example.mall.entity.Shop;
import com.example.mall.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping
    public List<Shop> getAll() {
        return service.getAllShops();
    }

    @GetMapping("/{id}")
    public Shop getById(@PathVariable Long id) {
        return service.getShopById(id);
    }

    @PostMapping
    public Shop create(@RequestBody Shop shop) {
        return service.createShop(shop);
    }

    @PutMapping("/{id}")
    public Shop update(@PathVariable Long id, @RequestBody Shop shop) {
        return service.updateShop(id, shop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteShop(id);
    }
}
