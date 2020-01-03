package com.adoptpet.pet.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptpet.pet.exception.ExceptionNonexistentObject;
import com.adoptpet.pet.model.User;
import com.adoptpet.pet.repository.UserRepository;
import com.adoptpet.pet.service.UserService;

/**
 * Part of negotiation of service user model, implements methods of interface
 * UserService.
 * 
 * @author jessikafernandes
 * @since 02/01/2020
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Metodo responsavel por criar listar de users cadastrados no banco
	// caso não exista, retorna a mensagem de pet não encontrado
	@Override
	public List<User> listUsers() {
		List<User> users = userRepository.findAll();
		if (users.size() > 0) {
			return users;
		} else {
			throw new ExceptionNonexistentObject("Nenhum usuário cadastrado no sistema.");
		}
	}

	// Retorna usuário por Id
	@Override
	public Optional<User> findUserId(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user;
		} else {
			throw new ExceptionNonexistentObject("O id = " + id + " do usuário não foi encontrado ou não existe.");
		}
	}

	// Create new user
	@Override
	public User newUser(User user) {
		User userIn = userRepository.save(user);
		return userIn;
	}

	// Update data to user by id
	@Override
	public User updateUser(User user, Long id) {
		Optional<User> userIn = userRepository.findById(id);
		if (userIn.isPresent()) {
			userRepository.save(user);
			return user;
		} else {
			throw new ExceptionNonexistentObject("O id update = " + id + " do pet não foi encontrado ou não existe.");
		}
	}

}
