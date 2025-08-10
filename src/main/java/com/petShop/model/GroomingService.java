package com.petShop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "grooming_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroomingService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;
    private Boolean available;

    @ManyToMany(mappedBy = "groomingServices")
    private List<Pet> pets;
}
