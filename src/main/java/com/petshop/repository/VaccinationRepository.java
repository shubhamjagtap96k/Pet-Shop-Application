package com.petshop.repository;

import com.petshop.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {
    List<Vaccination> findByNameContainingIgnoreCase(String name);
}