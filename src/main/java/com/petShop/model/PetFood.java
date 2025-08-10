package com.petShop.model;

import jakarta.persistence.*;
import lombok.*;
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
    private Integer id;

    @Column(length = 255)
    private String name;

    @Column(length = 100)
    private String brand;

    @Column(length = 50)
    private String type;

    private Integer quantity;
    private Double price;

    @ManyToMany(mappedBy = "foods")
    private List<Pet> pets;
}
