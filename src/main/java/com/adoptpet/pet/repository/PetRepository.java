package com.adoptpet.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptpet.pet.model.Pet;

/**
* Implement an application repository Pet.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

public interface PetRepository extends JpaRepository<Pet, Long> {
  
}
