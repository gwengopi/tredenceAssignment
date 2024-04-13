package com.tredence.assignment.api.repo;

import com.tredence.assignment.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
   /* List<Product> findByProductIdIn(List<String> productIds, int limit);

    List<Product> findByProductIdInAndCategory(List<String> productIds, String category, int limit);

    List<Product> findByProductIdInAndBrand(List<String> productIds, String brand, int limit);

    List<Product> findByProductIdInAndCategoryAndBrand(List<String> productIds, String category, String brand, int limit);
*/
    List<Product> findByProductIdIn(List<String> productIds);

    List<Product> findByProductIdInAndCategory(List<String> productIds, String category);

    List<Product> findByProductIdInAndBrand(List<String> productIds, String brand);

    List<Product> findByProductIdInAndCategoryAndBrand(List<String> productIds, String category, String brand);
}