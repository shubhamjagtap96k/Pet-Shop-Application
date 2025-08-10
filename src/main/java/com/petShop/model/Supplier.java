package com.petShop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(name = "contact_person", length = 50)
    private String contactPerson;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "suppliers")
    private List<Pet> pets;
}
