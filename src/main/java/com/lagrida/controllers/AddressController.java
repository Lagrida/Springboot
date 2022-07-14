package com.lagrida.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lagrida.entities.Address;
import com.lagrida.entities.TypeAddress;
import com.lagrida.repositories.AddressRepository;
import com.lagrida.repositories.TypeAddressRepository;

@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private TypeAddressRepository typeAddressRepository;
	
	@GetMapping("/addresses")
	@Transactional
	public String addAddresses() {
		TypeAddress typeAddress1 = new TypeAddress(null, "Professionelle");
		TypeAddress typeAddress2 = new TypeAddress(null, "Personnelle");
		
		typeAddressRepository.save(typeAddress1);
		typeAddressRepository.save(typeAddress2);
		
		Address address1 = new Address(null, "street pro 1", typeAddress1);
		Address address2 = new Address(null, "street pro 2", typeAddress1);
		
		Address address3 = new Address(null, "street perso 1", typeAddress2);
		Address address4 = new Address(null, "street perso 2", typeAddress2);
		
		addressRepository.save(address1);
		addressRepository.save(address2);
		addressRepository.save(address3);
		addressRepository.save(address4);
		return "OK";
	}
}
