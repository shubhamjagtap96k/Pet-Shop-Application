package com.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pet_food")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Integer foodId;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "brand", length = 100)
    private String brand;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "available")
    private Boolean available;

    @ManyToMany(mappedBy = "petFoods")
    private List<Pet> pets;
}