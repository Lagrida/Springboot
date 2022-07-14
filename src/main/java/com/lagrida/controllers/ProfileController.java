package com.lagrida.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lagrida.entities.Address;
import com.lagrida.entities.Profile;
import com.lagrida.entities.TypeAddress;
import com.lagrida.repositories.ProfileRepository;
import com.lagrida.repositories.TypeAddressRepository;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private TypeAddressRepository typeAddressRepository;
	
	@GetMapping("/get_all_profiles")
	public List<Profile> getAll(){
		return profileRepository.findAll();
	}
	
	@GetMapping("/add_profile")
	@Transactional
	public String addAddresses() {
		TypeAddress typeAddress = typeAddressRepository.findById(1).orElseThrow(() -> new RuntimeException("Erreur"));
		Set<Address> addresses = new HashSet<Address>();
		
		Address address1 = new Address(null, "street pro 5", typeAddress);
		Address address2 = new Address(null, "street pro 6", typeAddress);
		
		addresses.add(address1);
		addresses.add(address2);
		
		Profile profile = new Profile(null, "Profile 5", addresses);
		profileRepository.save(profile);
		return "OK";
	}
}
