package com.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
    private Integer supplierId;
    private String name;
    private String contactPerson;
    private String phoneNumber;
    private String email;
    private AddressDTO address;
}
