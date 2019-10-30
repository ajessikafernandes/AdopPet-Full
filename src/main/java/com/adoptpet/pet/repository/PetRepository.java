package com.adoptpet.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptpet.pet.model.Pet;

/**
 * @author jessikafernandess 
 */

public interface PetRepository extends JpaRepository<Pet, Long> {
  
}
