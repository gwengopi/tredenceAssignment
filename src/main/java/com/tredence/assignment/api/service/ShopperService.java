package com.tredence.assignment.api.service;

import com.tredence.assignment.api.entity.Product;
import com.tredence.assignment.api.entity.ShelfItem;
import com.tredence.assignment.api.entity.Shopper;
import com.tredence.assignment.api.repo.ProductRepository;
import com.tredence.assignment.api.repo.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// ShopperService
@Service
public class ShopperService {
    @Autowired
    private final ShopperRepository shopperRepository;
    @Autowired
    private ProductRepository productRepository;

    public ShopperService(ShopperRepository shopperRepository) {
        this.shopperRepository = shopperRepository;
    }

    public void saveShopper(Shopper shopper) {
        shopperRepository.save(shopper);
    }

    public Shopper getShopperById(String shopperId) {
        return shopperRepository.findById(shopperId).orElse(null);
    }
    public List<Product> getProductsByShopperId(String shopperId, String category, String brand, int limit) {
        // Retrieve shopper details by ID
        Optional<Shopper> shopper = shopperRepository.findById(shopperId);
        Shopper retirevedShopper = null;
        // If shopper found, get the product IDs from the shelf
        if (shopper.isPresent()) {
            retirevedShopper =shopper.get();
            List<String> productIds = new ArrayList<>();
            for (ShelfItem shelfItem : retirevedShopper.getShelf()) {
                productIds.add(shelfItem.getProductId());
            }

            // Fetch the actual product details based on the retrieved product IDs and optional filters
            List<Product> products;
            if (category != null && brand != null) {
                products = productRepository.findByProductIdInAndCategoryAndBrand(productIds, category, brand);
            } else if (category != null) {
                products = productRepository.findByProductIdInAndCategory(productIds, category);
            } else if (brand != null) {
                products = productRepository.findByProductIdInAndBrand(productIds, brand);
            } else {
                products = productRepository.findByProductIdIn(productIds);
            }
            return products;
        } else {
            return null; // Or throw an exception if desired
        }
    }
}

