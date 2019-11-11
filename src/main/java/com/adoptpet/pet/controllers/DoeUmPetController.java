package com.adoptpet.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Implement a page doe-um-pet.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

@Controller
public class DoeUmPetController {

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(doe-um-pet.html) DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@GetMapping("/doe-um-pet")
	public String index() {
		return "doe-um-pet";
	}
}
