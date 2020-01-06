package com.adoptpet.pet.service;

import java.util.List;
import java.util.Optional;

import com.adoptpet.pet.model.Address;

/**
 * Implementing methods
 * 
 * @author jessikafernandes
 * @since 03/01/2020
 */

public interface AddressService {

	List<Address> listaAddress();

	Optional<Address> findAddressId(Long id);

	Address newAddress(Address address);

	Address updateAddress(Address address, Long id);

}
