package com.petShop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "pet_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Pet> pets;
}
