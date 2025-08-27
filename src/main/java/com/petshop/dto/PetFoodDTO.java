package com.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetFoodDTO {
    private Integer foodId;
    private String name;
    private String brand;
    private String type;
    private Integer quantity;
    private BigDecimal price;
    private Boolean available;
}