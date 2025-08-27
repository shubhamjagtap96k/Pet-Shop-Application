package com.petshop.repository;

import com.petshop.entity.PetFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PetFoodRepository extends JpaRepository<PetFood, Integer> {
    List<PetFood> findByBrand(String brand);
    List<PetFood> findByType(String type);
    List<PetFood> findByAvailable(Boolean available);
    List<PetFood> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<PetFood> findByNameContainingIgnoreCase(String name);
    List<PetFood> findByBrandAndType(String brand, String type);
}
