package com.adoptpet.pet.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptpet.pet.exception.ExceptionNonexistentObject;
import com.adoptpet.pet.model.Address;
import com.adoptpet.pet.repository.AddressRepository;
import com.adoptpet.pet.service.AddressService;

/**
 * Part of negotiation of service address model, implements methods of interface
 * AddressService.
 * 
 * @author jessikafernandes!
 * @since 03/01/2020
 */

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	// Metodo responsavel por criar listar de endereços cadastrados no banco
	// caso não exista, retorna a mensagem de pet não encontrado
	@Override
	public List<Address> listaAddress() {
		List<Address> address = addressRepository.findAll();
		if (address.size() > 0) {
			return address;
		} else {
			throw new ExceptionNonexistentObject("Não existem endereços cadastrados.");
		}
	}

	// Metodo responsavel por buscar Endereço por Id
	@Override
	public Optional<Address> findAddressId(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		if (address.isPresent()) {
			return address;
		} else {
			throw new ExceptionNonexistentObject("O id = " + id + " do endereço não foi encontrado ou não existe.");
		}
	}

	// Metodo responsavel por cadastrar um novo endereço
	@Override
	public Address newAddress(Address address) {
		Address addressIn = addressRepository.save(address);
		return addressIn;
	}

	//Atualiza dados cadastrados no endereço
	@Override
	public Address updateAddress(Address address, Long id) {
		Optional<Address> addressIn = addressRepository.findById(id);
		if (addressIn.isPresent()) {
			addressRepository.save(address);
			return address;
		} else {
			throw new ExceptionNonexistentObject("O id update = " + id + " do pet não foi encontrado ou não existe.");
		}
	}

}
