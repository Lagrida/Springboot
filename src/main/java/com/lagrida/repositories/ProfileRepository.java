package com.lagrida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lagrida.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
