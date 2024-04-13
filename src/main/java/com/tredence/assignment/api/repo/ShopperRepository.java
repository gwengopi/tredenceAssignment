package com.tredence.assignment.api.repo;

import com.tredence.assignment.api.entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper, String> {
}
