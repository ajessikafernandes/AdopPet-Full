package com.adoptpet.pet.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptpet.pet.exception.ExceptionNonexistentObject;
import com.adoptpet.pet.model.User;
import com.adoptpet.pet.service.UserService;

/**
 * Implement a page adote/pet/user.
 *
 * @author jessikafernandes
 * @since 02/01/2020
 */

@RestController
@RequestMapping(path = "adote/pet/user")
public class UserController {

	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Retorna uma lista de usuarios
	@GetMapping("list")
	public ResponseEntity<?> list() {
		List<User> user = userService.listUsers();
		if (user.size() > 0) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.badRequest()
					.body(new ExceptionNonexistentObject("Nenhum usuário cadastrado no sistema."));
		}
	}

	// Metodo responsavel por buscar User por Id
	@GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<User> user = userService.findUserId(id);
		if (user.isPresent()) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.badRequest().body(
					new ExceptionNonexistentObject("O id = " + id + " do usuário não foi encontrado ou não existe"));
		}
	}

	// Metodo responsavel por criar um novo usuario
	@PostMapping("new")
	public ResponseEntity<User> newUser(@RequestBody @Valid User user) {
		User newUser = userService.newUser(user);
		return new ResponseEntity<>(userService.newUser(newUser), HttpStatus.CREATED);
	}

	// Metodo responsavel por atualizar dados do usuario por id
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<Object> updatePet(@RequestBody @Valid User user, @PathVariable(value = "id") Long id) {
		Optional<User> userIn = userService.findUserId(id);
		if (userIn.isPresent()) {
			User user1 = userService.updateUser(user, id);
			return ResponseEntity.ok(userService.updateUser(user1, id));
		} else {
			return ResponseEntity.badRequest().body(new ExceptionNonexistentObject("nenhum usuário foi atualizado"));
		}
	}

}
