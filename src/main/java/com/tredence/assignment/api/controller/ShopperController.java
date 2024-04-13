package com.tredence.assignment.api.controller;

import com.tredence.assignment.api.entity.Shopper;
import com.tredence.assignment.api.service.ShopperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopperController {

    private final ShopperService shopperService;

    public ShopperController(ShopperService shopperService) {
        this.shopperService = shopperService;
    }

    @PostMapping("/api/personalized-info")
    public ResponseEntity<String> receivePersonalizedInfo(@RequestBody Shopper shopper) {
        try {
            shopperService.saveShopper(shopper);
            return ResponseEntity.status(HttpStatus.CREATED).body("Shopper personalized information received and saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save shopper personalized information.");
        }
    }

    @GetMapping("/api/shopper/{shopperId}")
    public ResponseEntity<Object> getShopperDetails(@PathVariable String shopperId) {
        try {
            Shopper shopper = shopperService.getShopperById(shopperId);
            if (shopper != null) {
                return ResponseEntity.ok(shopper);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve shopper details.");
        }
    }
}
