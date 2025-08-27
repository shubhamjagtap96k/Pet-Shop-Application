package com.petshop.repository;

import com.petshop.entity.Pet;
import com.petshop.entity.PetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByCategory(PetCategory category);
    List<Pet> findByBreed(String breed);
    List<Pet> findByNameContainingIgnoreCase(String name);
    List<Pet> findByAge(Integer age);
    List<Pet> findByAgeBetween(Integer minAge, Integer maxAge);
    List<Pet> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Pet> findByBreedAndCategory(String breed, PetCategory category);

    @Query("SELECT p FROM Pet p WHERE p.price <= :maxPrice AND p.category = :category")
    List<Pet> findAffordablePetsByCategory(@Param("maxPrice") BigDecimal maxPrice,
                                           @Param("category") PetCategory category);

    @Query("SELECT p FROM Pet p JOIN p.employees e WHERE e.employeeId = :employeeId")
    List<Pet> findPetsByEmployee(@Param("employeeId") Integer employeeId);
}