package com.tredence.assignment.api.controller;

import com.tredence.assignment.api.entity.Product;
import com.tredence.assignment.api.repo.ProductRepository;
import com.tredence.assignment.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ProductController
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @PostMapping("/saveProducts")
    public ResponseEntity<String> saveProducts(@RequestBody List<Product> products) {
        try {
            productService.saveProducts(products);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product details saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save product details.");
        }
    }
}

