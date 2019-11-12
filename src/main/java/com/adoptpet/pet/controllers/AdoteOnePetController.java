package com.adoptpet.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Implement a page adote-um-pet.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

@Controller
public class AdoteOnePetController {

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(adote-um-pet.html) DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@GetMapping("/adote-um-pet")
	public String adotePet() {
		return "adote-um-pet";
	}
}
