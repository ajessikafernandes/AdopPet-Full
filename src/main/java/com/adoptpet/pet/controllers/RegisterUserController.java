package com.adoptpet.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Implement a page register-user.
*
* @author jessikafernandes
* @since   10/11/2019
*/

@Controller
public class RegisterUserController {

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(register-user.html) DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@GetMapping("/register-user")
	public String index() {
		return "register-user";
	}

}
