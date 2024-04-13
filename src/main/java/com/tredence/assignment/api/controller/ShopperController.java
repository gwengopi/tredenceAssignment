package com.tredence.assignment.api.controller;

import com.tredence.assignment.api.entity.Product;
import com.tredence.assignment.api.entity.Shopper;
import com.tredence.assignment.api.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shopper")
public class ShopperController {


    private final ShopperService shopperService;

    public ShopperController(ShopperService shopperService) {
        this.shopperService = shopperService;
    }

    //API to receive and savi personalized details of shopper
    @PostMapping("/personalized-info")
    public ResponseEntity<String> receivePersonalizedInfo(@RequestBody Shopper shopper) {
        try {
            shopperService.saveShopper(shopper);
            return ResponseEntity.status(HttpStatus.CREATED).body("Shopper personalized information received and saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save shopper personalized information.");
        }
    }

//    Retrieve products by shopper id
    @GetMapping("/{shopperId}")
    public ResponseEntity<List<Product>> getProductsByShopper(@PathVariable String shopperId,
                                                              @RequestParam(required = false) String category,
                                                              @RequestParam(required = false) String brand,
                                                              @RequestParam(defaultValue = "10") int limit) {
        // Implement logic to fetch products by shopper ID with optional filters
        List<Product> products = shopperService.getProductsByShopperId(shopperId, category, brand, limit);
        return ResponseEntity.ok(products);
    }
}
