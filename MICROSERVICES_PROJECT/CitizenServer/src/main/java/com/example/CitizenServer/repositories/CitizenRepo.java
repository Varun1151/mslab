package com.example.CitizenServer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CitizenServer.Entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCenterId(Integer id);

}