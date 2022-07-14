package com.lagrida.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lagrida.entities.Address;
import com.lagrida.entities.Multiproperty;
import com.lagrida.entities.TypeAddress;
import com.lagrida.repositories.MultipropertyRepository;
import com.lagrida.repositories.TypeAddressRepository;

@RestController
public class MultipropertyController {
	@Autowired
	private TypeAddressRepository typeAddressRepository;
	
	@Autowired
	private MultipropertyRepository multipropertyRepository;
	
	@GetMapping("/get_all_multiproperties")
	public List<Multiproperty> getAll(){
		return multipropertyRepository.findAll();
	}
	@GetMapping("/add_multiproperty")
	@Transactional
	public String addAddresses() {
		TypeAddress typeAddress = typeAddressRepository.findById(2).orElseThrow(() -> new RuntimeException("Erreur"));
		Set<Address> addresses = new HashSet<Address>();
		
		Address address1 = new Address(null, "street exemple 1", typeAddress);
		Address address2 = new Address(null, "street exemple 2", typeAddress);
		
		addresses.add(address1);
		addresses.add(address2);
		
		Multiproperty multiproperty = new Multiproperty(null, "MultiProperty", addresses);
		multipropertyRepository.save(multiproperty);
		return "OK";
	}
}
