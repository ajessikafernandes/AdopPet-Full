package com.adoptpet.pet.service;

import java.util.List;
import java.util.Optional;

import com.adoptpet.pet.model.Pet;


public interface PetService {
	
	List<Pet> listaPets();
	
	Optional<Pet> findPetId(Long id);
	
	Pet newPet(Pet pet);
	
	Pet updatePet(Pet pet, Long id);
	
	Pet disablePet(Pet pet, Long id);
	
}