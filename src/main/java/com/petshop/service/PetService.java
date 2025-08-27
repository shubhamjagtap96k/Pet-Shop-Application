package com.petshop.service;

import com.petshop.dto.CreatePetDTO;
import com.petshop.dto.PetDTO;
import com.petshop.entity.Pet;
import com.petshop.entity.PetCategory;
import com.petshop.exception.ResourceNotFoundException;
import com.petshop.mapper.PetMapper;
import com.petshop.repository.PetCategoryRepository;
import com.petshop.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PetService {

    private final PetRepository petRepository;
    private final PetCategoryRepository petCategoryRepository;
    private final PetMapper petMapper;

    public List<PetDTO> getAllPets() {
        log.debug("Fetching all pets");
        return petRepository.findAll()
                .stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PetDTO getPetById(Integer petId) {
        log.debug("Fetching pet with id: {}", petId);
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + petId));
        return petMapper.toDTO(pet);
    }

    public PetDTO createPet(CreatePetDTO createPetDTO) {
        log.debug("Creating new pet: {}", createPetDTO.getName());

        PetCategory category = petCategoryRepository.findById(createPetDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + createPetDTO.getCategoryId()));

        Pet pet = petMapper.toEntity(createPetDTO);
        pet.setCategory(category);

        Pet savedPet = petRepository.save(pet);
        return petMapper.toDTO(savedPet);
    }

    public PetDTO updatePet(Integer petId, CreatePetDTO updatePetDTO) {
        log.debug("Updating pet with id: {}", petId);

        Pet existingPet = petRepository.findById(petId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + petId));

        PetCategory category = petCategoryRepository.findById(updatePetDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + updatePetDTO.getCategoryId()));

        existingPet.setName(updatePetDTO.getName());
        existingPet.setBreed(updatePetDTO.getBreed());
        existingPet.setAge(updatePetDTO.getAge());
        existingPet.setPrice(updatePetDTO.getPrice());
        existingPet.setDescription(updatePetDTO.getDescription());
        existingPet.setImageUrl(updatePetDTO.getImageUrl());
        existingPet.setCategory(category);

        Pet savedPet = petRepository.save(existingPet);
        return petMapper.toDTO(savedPet);
    }

    public void deletePet(Integer petId) {
        log.debug("Deleting pet with id: {}", petId);
        if (!petRepository.existsById(petId)) {
            throw new ResourceNotFoundException("Pet not found with id: " + petId);
        }
        petRepository.deleteById(petId);
    }

    public List<PetDTO> getPetsByCategory(Integer categoryId) {
        log.debug("Fetching pets by category id: {}", categoryId);
        PetCategory category = petCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        return petRepository.findByCategory(category)
                .stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PetDTO> getPetsByBreed(String breed) {
        log.debug("Fetching pets by breed: {}", breed);
        return petRepository.findByBreed(breed)
                .stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PetDTO> getPetsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        log.debug("Fetching pets by price range: {} - {}", minPrice, maxPrice);
        return petRepository.findByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PetDTO> searchPetsByName(String name) {
        log.debug("Searching pets by name: {}", name);
        return petRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }
}