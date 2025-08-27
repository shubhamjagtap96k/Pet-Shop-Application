//package com.petshop.mapper;
//
//import com.petshop.dto.CreatePetDTO;
//import com.petshop.dto.PetDTO;
//import com.petshop.entity.Pet;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring", uses = {PetCategoryMapper.class})
//public interface PetMapper {
//
//    @Mapping(target = "employeeIds", expression = "java(pet.getEmployees() != null ? pet.getEmployees().stream().map(e -> e.getEmployeeId()).collect(java.util.stream.Collectors.toList()) : null)")
//    @Mapping(target = "supplierIds", expression = "java(pet.getSuppliers() != null ? pet.getSuppliers().stream().map(s -> s.getSupplierId()).collect(java.util.stream.Collectors.toList()) : null)")
//    @Mapping(target = "petFoodIds", expression = "java(pet.getPetFoods() != null ? pet.getPetFoods().stream().map(f -> f.getFoodId()).collect(java.util.stream.Collectors.toList()) : null)")
//    @Mapping(target = "groomingServiceIds", expression = "java(pet.getGroomingServices() != null ? pet.getGroomingServices().stream().map(g -> g.getServiceId()).collect(java.util.stream.Collectors.toList()) : null)")
//    @Mapping(target = "vaccinationIds", expression = "java(pet.getVaccinations() != null ? pet.getVaccinations().stream().map(v -> v.getVaccinationId()).collect(java.util.stream.Collectors.toList()) : null)")
//    PetDTO toDTO(Pet pet);
//
//    @Mapping(target = "petId", ignore = true)
//    @Mapping(target = "category", ignore = true)
//    @Mapping(target = "employees", ignore = true)
//    @Mapping(target = "suppliers", ignore = true)
//    @Mapping(target = "petFoods", ignore = true)
//    @Mapping(target = "groomingServices", ignore = true)
//    @Mapping(target = "vaccinations", ignore = true)
//    @Mapping(target = "transactions", ignore = true)
//    Pet toEntity(CreatePetDTO createPetDTO);
//}