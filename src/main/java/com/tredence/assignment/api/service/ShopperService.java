package com.tredence.assignment.api.service;

import com.tredence.assignment.api.entity.Shopper;
import com.tredence.assignment.api.repo.ShopperRepository;
import org.springframework.stereotype.Service;

// ShopperService
@Service
public class ShopperService {
    private final ShopperRepository shopperRepository;

    public ShopperService(ShopperRepository shopperRepository) {
        this.shopperRepository = shopperRepository;
    }

    public void saveShopper(Shopper shopper) {
        shopperRepository.save(shopper);
    }
}

