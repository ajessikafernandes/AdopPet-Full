package com.adoptpet.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adoptpet.pet.model.User;

/**
 * @author jessikafernandess 
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByEmail(String email);
  
}
