package com.tredence.assignment.api.repo;

import com.tredence.assignment.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByShopperId(String shopperId, int limit);

    List<Product> findByShopperIdAndCategory(String shopperId, String category, int limit);

    List<Product> findByShopperIdAndBrand(String shopperId, String brand, int limit);

    @Query("SELECT p FROM Product p WHERE p.shopperId = ?1 AND p.category = ?2 AND p.brand = ?3")
    List<Product> findByShopperIdAndCategoryAndBrand(String shopperId, String category, String brand, int limit);
}