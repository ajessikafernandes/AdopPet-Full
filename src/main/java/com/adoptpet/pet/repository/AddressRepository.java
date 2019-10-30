package com.adoptpet.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptpet.pet.model.Address;

/**
 * @author jessikafernandess 
 */

public interface AddressRepository extends JpaRepository<Address, Long> {
  
}
