package com.adoptpet.pet.service;

import java.util.List;
import java.util.Optional;

import com.adoptpet.pet.model.User;

/**
 * Implementing methods 
 * 
 * @author jessikafernandes
 * @since 02/01/2020
 */

public interface UserService {

	List<User> listUsers();

	Optional<User> findUserId(Long id);

	User newUser(User user);

	User updateUser(User user, Long id);

}
