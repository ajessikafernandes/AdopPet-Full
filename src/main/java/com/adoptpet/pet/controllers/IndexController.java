package com.adoptpet.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Implement an application main paging index.
*
* @author  jessikafernandes
* @since   10/11/2019
*/

@Controller
public class IndexController {

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(index.html) PRINCIPAL DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
