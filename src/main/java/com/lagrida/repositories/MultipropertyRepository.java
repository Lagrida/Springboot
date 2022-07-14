package com.lagrida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lagrida.entities.Multiproperty;

@Repository
public interface MultipropertyRepository extends JpaRepository<Multiproperty, Integer>{

}
