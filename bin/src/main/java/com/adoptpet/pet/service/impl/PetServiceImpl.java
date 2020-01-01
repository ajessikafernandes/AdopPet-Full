package com.adoptpet.pet.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptpet.pet.enums.Status;
import com.adoptpet.pet.exception.ExceptionNonexistentObject;
import com.adoptpet.pet.model.Pet;
import com.adoptpet.pet.repository.PetRepository;
import com.adoptpet.pet.service.PetService;

/**
 * Part of negotiation of service pet model, implements methods of interface
 * PetService.
 * 
 * @author jessikafernandes!
 * @since 16/12/2019
 */

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	public PetServiceImpl(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	// Metodo responsavel por criar listar os Pets cadastrados no banco
	// caso não exista, retorna a mensagem de pet não encontrado
	@Override
	public List<Pet> listaPets() {
		List<Pet> pet = petRepository.findAll();
		if (pet.size() > 0) {
			System.out.println(">>>>>>>>>>> Imprimindo lista de pets: <<<<<<<<<<<<<<");
			System.out.println(pet);
			return pet;
		}
		throw new ExceptionNonexistentObject("Não há pets cadastrados no sistema.");
	}

	// Metodo responsavel por buscar Pet por Id
	@Override
	public Optional<Pet> findPetId(Long id) {
		Optional<Pet> pet = petRepository.findById(id);
		if (pet.isPresent()) {
//			System.out.println(">>>>>>>>>>> Imprimindo pet id " + id + ": <<<<<<<<<<<<<<");
//			System.out.println(pet.get().getNamePet());
			return pet;
		}
		throw new ExceptionNonexistentObject("O id = " + id + " do pet não foi encontrado ou não existe.");
	}

	// Metodo responsavel por criar um novo Pet
	@Override
	public Pet newPet(Pet pet) {
		Pet petIn = petRepository.save(pet);
		return petIn;
	}

	// Metodo responsavel por atualizar os dados do Pet
	@Override
	public Pet updatePet(Pet pet, Long id) {
		Optional<Pet> petIn = petRepository.findById(id);
		if (petIn.isPresent()) {
			petRepository.save(pet);
			return pet;
		}
		throw new ExceptionNonexistentObject("O id update = " + id + " do pet não foi encontrado ou não existe.");
	}

	@Override
	public Pet disablePet(Pet pet, Long id) {
		Optional<Pet> petIn = petRepository.findById(id);
		if (petIn.isPresent()) {
			Pet pet1 = petIn.get();
			if (pet1.getStatus().equals(Status.EM_PROCESSO)) {
				pet1.setStatus(Status.ADOTADO);
			}
			petRepository.save(pet1);
			return pet1;
		}
		return null;
	}
}