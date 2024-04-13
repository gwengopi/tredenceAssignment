package com.tredence.assignment.api.service;

import com.tredence.assignment.api.entity.Product;
import com.tredence.assignment.api.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByShopper(String shopperId, String category, String brand, int limit) {
        // Implement logic to fetch products by shopper ID with optional filters
        if (category != null && brand != null) {
            return productRepository.findByShopperIdAndCategoryAndBrand(shopperId, category, brand, limit);
        } else if (category != null) {
            return productRepository.findByShopperIdAndCategory(shopperId, category, limit);
        } else if (brand != null) {
            return productRepository.findByShopperIdAndBrand(shopperId, brand, limit);
        } else {
            return productRepository.findByShopperId(shopperId, limit);
        }
    }
}
