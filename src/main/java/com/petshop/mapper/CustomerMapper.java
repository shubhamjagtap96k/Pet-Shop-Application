//package com.petshop.mapper;
//
//import com.petshop.dto.CreateCustomerDTO;
//import com.petshop.dto.CustomerDTO;
//import com.petshop.entity.Customer;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring", uses = {AddressMapper.class})
//public interface CustomerMapper {
//
//    CustomerDTO toDTO(Customer customer);
//
//    @Mapping(target = "customerId", ignore = true)
//    @Mapping(target = "address", ignore = true)
//    @Mapping(target = "transactions", ignore = true)
//    Customer toEntity(CreateCustomerDTO createCustomerDTO);
//}
