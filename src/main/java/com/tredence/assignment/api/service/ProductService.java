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

    public void saveProducts(List<Product> products) {
        productRepository.saveAll(products);
    }
}
