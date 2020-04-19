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
import com.adoptpet.pet.model.Pet;
import com.adoptpet.pet.service.PetService;

@RestController
@RequestMapping(path = "adote/pet/")
public class PetController {

//	private PetService petService;
//
//	@Autowired
//	public PetController(PetService petService) {
//		this.petService = petService;
//	}
//
//	@GetMapping("list")
//	public ResponseEntity<?> listPet() {
//		List<Pet> pet = petService.listaPets();
//		if (pet.size() > 0) {
//			return ResponseEntity.ok(pet);
//		} else {
//			return ResponseEntity.badRequest()
//					.body(new ExceptionNonexistentObject("Não há pets cadastrados no sistema."));
//		}
//	}
//
//	@GetMapping("{id}")
//	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
//		Optional<Pet> pet = petService.findPetId(id);
//		if (pet.isPresent()) {
//			return ResponseEntity.ok(pet);
//		} else {
//			return ResponseEntity.badRequest()
//					.body(new ExceptionNonexistentObject("O id = " + id + " do pet não foi encontrado ou não existe"));
//		}
//	}
//
//	@PostMapping("new")
//	@Transactional
//	public ResponseEntity<Pet> newPet(@RequestBody @Valid Pet pet) {
//		Pet newPet = petService.newPet(pet);
//		return new ResponseEntity<>(petService.newPet(newPet), HttpStatus.CREATED);
//	}
//
//	@PutMapping("{id}")
//	@Transactional
//	public ResponseEntity<Object> updatePet(@RequestBody @Valid Pet pet, @PathVariable(value = "id") Long id) {
//		Optional<Pet> petIn = petService.findPetId(id);
//		if (petIn.isPresent()) {
//			Pet pet1 = petService.updatePet(pet, id);
//			return ResponseEntity.ok(petService.updatePet(pet1, id));
//		} else {
//			return ResponseEntity.badRequest().body(new ExceptionNonexistentObject("nenhum pet atualizado"));
//		}
//	}

}