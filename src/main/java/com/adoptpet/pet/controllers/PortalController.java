package com.adoptpet.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Implement a page portal.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

@Controller
public class PortalController {

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(portal.html) DA NOSSA APLICAÇÃO
	 */
	@GetMapping("/portal")
	public String portal() {
		return "portal";
	}
}
