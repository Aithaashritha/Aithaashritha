package com.example.mall.service;

import com.example.mall.entity.Shop;
import com.example.mall.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository repo;

    public ShopService(ShopRepository repo) {
        this.repo = repo;
    }

    public List<Shop> getAllShops() {
        return repo.findAll();
    }

    public Shop getShopById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Shop createShop(Shop shop) {
        return repo.save(shop);
    }

    public Shop updateShop(Long id, Shop details) {
        Shop shop = repo.findById(id).orElse(null);
        if (shop != null) {
            shop.setName(details.getName());
            shop.setCategory(details.getCategory());
            shop.setMall(details.getMall());
            return repo.save(shop);
        }
        return null;
    }

    public void deleteShop(Long id) {
        repo.deleteById(id);
    }
}
