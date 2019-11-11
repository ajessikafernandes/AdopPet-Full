package com.adoptpet.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptpet.pet.model.User;

/**
* Implement an application repository User.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

public interface UserRepository extends JpaRepository<User, Long> {
      
}
