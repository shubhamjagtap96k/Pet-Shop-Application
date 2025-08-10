package com.petShop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer id;

    @Column(length = 255)
    private String name;

    @Column(length = 50)
    private String breed;

    private Integer age;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PetCategory category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @ManyToMany
    @JoinTable(
            name = "pet_vaccination_relationship",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccination_id")
    )
    private List<Vaccination> vaccinations;

    @ManyToMany
    @JoinTable(
            name = "pet_food_relationship",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<PetFood> foods;

    @ManyToMany
    @JoinTable(
            name = "pet_grooming_relationship",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<GroomingService> groomingServices;

    @ManyToMany
    @JoinTable(
            name = "pet_supplier_relationship",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> suppliers;
}
