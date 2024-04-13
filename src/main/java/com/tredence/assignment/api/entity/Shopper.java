package com.tredence.assignment.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "shopper")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Shopper {
    @Id
    @Column(name = "shopper_id")
    private String shopperId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopper_id", referencedColumnName = "shopper_id")
    private List<ShelfItem> shelf;

}
