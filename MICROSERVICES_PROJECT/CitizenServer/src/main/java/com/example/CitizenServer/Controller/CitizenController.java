package com.example.CitizenServer.Controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CitizenServer.Entity.Citizen;
import com.example.CitizenServer.repositories.CitizenRepo;


@RequestMapping("/citizen")
@RestController
public class CitizenController {
	
	
	private CitizenRepo repo; 
	public CitizenController(CitizenRepo repo){
		this.repo = repo;
	}
	
	@RequestMapping(path ="/id/{id}")
	public Citizen getById(@PathVariable Integer id) {
		return repo.findById(id).orElse(null);
	}

	@RequestMapping(path="/vacc_id/{id}")
	public List<Citizen> getByCenterId(@PathVariable Integer id) {
		return repo.findByVaccinationCenterId(id);
	}
	
	@PostMapping(path ="/add")
	public Citizen addCitizen(@RequestBody Citizen newCitizen) {
		return repo.save(newCitizen);
	}	

	@DeleteMapping(path="/delete/{id}")
	public String deleteCitizen(@PathVariable Integer id){
		repo.deleteById(id);
		return "Citzen with id = "+id+" deleted";
	}
}