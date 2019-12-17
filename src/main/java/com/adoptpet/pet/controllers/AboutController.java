package com.adoptpet.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Implement a page about.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

@Controller
public class AboutController {

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(about.html) DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@GetMapping("/about")
	public String sobre() {
		return "about";
	}
	
	
}
