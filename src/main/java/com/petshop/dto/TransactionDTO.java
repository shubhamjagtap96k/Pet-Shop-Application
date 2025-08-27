package com.petshop.dto;

import com.petshop.entity.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Integer transactionId;
    private Integer customerId;
    private Integer petId;
    private LocalDate transactionDate;
    private BigDecimal amount;
    private TransactionStatus transactionStatus;
    private String customerName;
    private String petName;
}