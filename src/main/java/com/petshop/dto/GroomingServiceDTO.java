package com.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroomingServiceDTO {
    private Integer serviceId;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;
}