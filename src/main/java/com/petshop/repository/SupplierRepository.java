package com.petshop.repository;

import com.petshop.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Optional<Supplier> findByEmail(String email);
    List<Supplier> findByNameContainingIgnoreCase(String name);
    List<Supplier> findByContactPersonContainingIgnoreCase(String contactPerson);
}