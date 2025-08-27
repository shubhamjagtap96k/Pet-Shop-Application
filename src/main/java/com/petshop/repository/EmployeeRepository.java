package com.petshop.repository;

import com.petshop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByPosition(String position);
    Optional<Employee> findByEmail(String email);
    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
    List<Employee> findByLastNameContainingIgnoreCase(String lastName);
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %?1% OR e.lastName LIKE %?1%")
    List<Employee> findByFullNameContaining(String name);
}