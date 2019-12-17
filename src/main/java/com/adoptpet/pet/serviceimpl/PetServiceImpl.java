package com.adoptpet.pet.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptpet.pet.exception.ExceptionNonexistentObject;
import com.adoptpet.pet.model.Pet;
import com.adoptpet.pet.repository.PetRepository;
import com.adoptpet.pet.service.PetService;

/**
 * Part of negotiation of service pet model, implements methods of interface
 * PetService.
 * 
 * @author jessikafernandes!
 * @since 08/12/2019
 */

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	public PetServiceImpl(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public List<Pet> listaPets() {
		List<Pet> pet = petRepository.findAll();
		if (pet.size() > 0) {
			System.out.println("imprimindo pet");
			return pet;
		}
		throw new ExceptionNonexistentObject("Nenhum pet encontrado no sistema.");

	}

}
