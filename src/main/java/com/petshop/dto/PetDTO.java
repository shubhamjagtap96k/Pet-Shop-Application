package com.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private Integer petId;
    private String name;
    private String breed;
    private Integer age;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private PetCategoryDTO category;
    private List<Integer> employeeIds;
    private List<Integer> supplierIds;
    private List<Integer> petFoodIds;
    private List<Integer> groomingServiceIds;
    private List<Integer> vaccinationIds;
}
