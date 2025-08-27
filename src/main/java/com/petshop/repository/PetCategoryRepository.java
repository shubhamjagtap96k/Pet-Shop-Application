package com.petshop.repository;

import com.petshop.entity.PetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetCategoryRepository extends JpaRepository<PetCategory, Integer> {
    Optional<PetCategory> findByName(String name);
}