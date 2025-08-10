package com.petShop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "vaccinations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccination_id")
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;
    private Boolean available;

    @ManyToMany(mappedBy = "vaccinations")
    private List<Pet> pets;
}
