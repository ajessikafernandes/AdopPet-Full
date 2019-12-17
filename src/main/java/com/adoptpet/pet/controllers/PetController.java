package com.adoptpet.pet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptpet.pet.exception.ExceptionNonexistentObject;
import com.adoptpet.pet.model.Pet;
import com.adoptpet.pet.service.PetService;

/**
* Implement a page adote-um-pet.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

@RestController
@RequestMapping(path = "adote/pet/")
public class PetController {
	
	private PetService petService;
	
	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}

//	/***
//	 * ESSE MÉTODO CARREGA A PÁGINA(adote-um-pet.html) DA NOSSA APLICAÇÃO
//	 * 
//	 * @return
//	 */
//	@GetMapping("/adote-um-pet")
//	public String adoteUmPet() {
//		return "adote-um-pet";
//	}
//	

	@GetMapping("list")
	public ResponseEntity<?> listPet() throws ExceptionNonexistentObject {
		List<Pet> pet = petService.listaPets();
		if(pet.size()>0) {
			return ResponseEntity.ok(pet);
		} else {
			return ResponseEntity.badRequest().body(new ExceptionNonexistentObject("Nenhum pet cadastrado"));
		}
	}
}
