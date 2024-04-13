package com.tredence.assignment.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shelf_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShelfItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "relevancy_score")
    private double relevancyScore;

}