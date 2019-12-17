package com.adoptpet.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Implement a page register-user.
*
* @author jessikafernandes
* @since   10/11/2019
*/

@RestController
@RequestMapping(path = "register-user/")
public class RegisterUserController {

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(register-user.html) DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@GetMapping("/register-user")
	public String registerUser() {
		return "register-user";
	}
	
	

}
