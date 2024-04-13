package com.tredence.assignment.api.controller;

import com.tredence.assignment.api.entity.Product;
import com.tredence.assignment.api.repo.ProductRepository;
import com.tredence.assignment.api.service.ProductService;
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

    @GetMapping("/shopper/{shopperId}")
    public ResponseEntity<List<Product>> getProductsByShopper(@PathVariable String shopperId,
                                                              @RequestParam(required = false) String category,
                                                              @RequestParam(required = false) String brand,
                                                              @RequestParam(defaultValue = "10") int limit) {
        // Implement logic to fetch products by shopper ID with optional filters
        List<Product> products = productService.getProductsByShopper(shopperId, category, brand, limit);
        return ResponseEntity.ok(products);
    }
}

