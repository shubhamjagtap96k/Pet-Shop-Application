package com.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private LocalDate hireDate;
    private String phoneNumber;
    private String email;
    private AddressDTO address;
}
