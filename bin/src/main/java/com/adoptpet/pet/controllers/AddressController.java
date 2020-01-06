package com.adoptpet.pet.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptpet.pet.exception.ExceptionNonexistentObject;
import com.adoptpet.pet.model.Address;
import com.adoptpet.pet.service.AddressService;

/**
 * Implement a page adote/pet/.
 *
 * @author jessikafernandes
 * @since 03/01/2020
 */

@RestController
@RequestMapping(path = "adote/pet/address")
public class AddressController {

	private AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	// Metodo responsavel por listar os endereços cadastrados no banco
	// caso não exista, retorna a mensagem de endereço não encontrado
	@GetMapping("list")
	public ResponseEntity<?> listAddress() {
		List<Address> address = addressService.listaAddress();
		if (address.size() > 0) {
			return ResponseEntity.ok(address);
		} else {
			return ResponseEntity.badRequest()
					.body(new ExceptionNonexistentObject("Não há endereços cadastrados no sistema."));
		}
	}

	// Metodo responsavel por buscar Address por Id
	@GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<Address> address = addressService.findAddressId(id);
		if (address.isPresent()) {
			return ResponseEntity.ok(address);
		} else {
			return ResponseEntity.badRequest()
					.body(new ExceptionNonexistentObject("O id " + id + " não foi encontrado ou não existe."));
		}
	}

	// Metodo responsavel por criar um novo Address
	@PostMapping("new")
	public ResponseEntity<Object> newAddress(@RequestBody @Valid Address address) {
		Address newAddress = addressService.newAddress(address);
		return new ResponseEntity<>(addressService.newAddress(newAddress), HttpStatus.CREATED);
	}

	// Metodo responsavel por atualizar os dados do Usuário
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<Object> updateAddress(@RequestBody @Valid Address address,
			@PathVariable(value = "id") Long id) {
		Optional<Address> addressIn = addressService.findAddressId(id);
		if (addressIn.isPresent()) {
			Address address1 = addressService.updateAddress(address, id);
			return ResponseEntity.ok(addressService.updateAddress(address1, id));
		} else {
			return ResponseEntity.badRequest().body(new ExceptionNonexistentObject("O endereço não foi atualizado."));
		}
	}

}
