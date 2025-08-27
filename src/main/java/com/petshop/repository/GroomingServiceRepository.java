package com.petshop.repository;

import com.petshop.entity.GroomingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GroomingServiceRepository extends JpaRepository<GroomingService, Integer> {
    List<GroomingService> findByAvailable(Boolean available);
    List<GroomingService> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<GroomingService> findByNameContainingIgnoreCase(String name);
}