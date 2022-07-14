package com.lagrida.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "profile_address",
		joinColumns = {@JoinColumn(name = "id_profile")},
		inverseJoinColumns = {@JoinColumn(name = "id_address")}
	)
	private Set<Address> addresses;
}
