package com.petshop.repository;

import com.petshop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCity(String city);
    List<Address> findByState(String state);
    List<Address> findByCityAndState(String city, String state);

    @Query("SELECT a FROM Address a WHERE a.zipCode = ?1")
    List<Address> findByZipCode(String zipCode);
}