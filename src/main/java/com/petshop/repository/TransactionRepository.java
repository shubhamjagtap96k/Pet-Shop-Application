package com.petshop.repository;

import com.petshop.entity.Transaction;
import com.petshop.entity.TransactionStatus;
import com.petshop.entity.Customer;
import com.petshop.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByCustomer(Customer customer);
    List<Transaction> findByPet(Pet pet);
    List<Transaction> findByTransactionStatus(TransactionStatus status);
    List<Transaction> findByTransactionDateBetween(LocalDate startDate, LocalDate endDate);
    List<Transaction> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);
    List<Transaction> findByCustomerAndTransactionStatus(Customer customer, TransactionStatus status);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.transactionStatus = :status")
    BigDecimal getTotalAmountByStatus(@Param("status") TransactionStatus status);

    @Query("SELECT t FROM Transaction t WHERE t.transactionDate >= :date AND t.transactionStatus = :status")
    List<Transaction> findTransactionsFromDateWithStatus(@Param("date") LocalDate date,
                                                         @Param("status") TransactionStatus status);

    @Query("SELECT COUNT(t) FROM Transaction t WHERE t.customer = :customer")
    Long countTransactionsByCustomer(@Param("customer") Customer customer);
}