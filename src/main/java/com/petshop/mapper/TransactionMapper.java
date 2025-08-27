//package com.petshop.mapper;
//
//import com.petshop.dto.TransactionDTO;
//import com.petshop.entity.Transaction;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring")
//public interface TransactionMapper {
//
//    @Mapping(target = "customerId", source = "customer.customerId")
//    @Mapping(target = "petId", source = "pet.petId")
//    @Mapping(target = "customerName", expression = "java(transaction.getCustomer() != null ? transaction.getCustomer().getFirstName() + \" \" + transaction.getCustomer().getLastName() : null)")
//    @Mapping(target = "petName", source = "pet.name")
//    TransactionDTO toDTO(Transaction transaction);
//
//    @Mapping(target = "customer", ignore = true)
//    @Mapping(target = "pet", ignore = true)
//    Transaction toEntity(TransactionDTO transactionDTO);
//}
