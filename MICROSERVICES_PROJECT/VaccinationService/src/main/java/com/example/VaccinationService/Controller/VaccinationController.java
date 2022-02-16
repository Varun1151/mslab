package com.example.VaccinationService.Controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.VaccinationService.Entity.VaccinationCenter;
import com.example.VaccinationService.Model.Citizen;
import com.example.VaccinationService.Model.RequiredResponse;
import com.example.VaccinationService.repositories.VaccinationRepo;

@RequestMapping("/vaccinationcenter")
@RestController
public class VaccinationController {
	
	// @Autowired
	private VaccinationRepo centerRepo;
	
	// @Autowired
	private RestTemplate restTemplate;
	public VaccinationController(VaccinationRepo centerRepo,RestTemplate restTemplate){
		this.centerRepo = centerRepo;
		this.restTemplate = restTemplate;
	}
	
	@PostMapping(path ="/add")
	public VaccinationCenter addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {
		return centerRepo.save(vaccinationCenter);
	}
	
	@GetMapping(path="/all")
	public List<VaccinationCenter> getAllVaccinationCenters(){
		return centerRepo.findAll();
	}


	@GetMapping(path = "/id/{id}")
	public RequiredResponse getAllDataBasedonCenterId(@PathVariable Integer id){
		RequiredResponse requiredResponse =  new RequiredResponse();
		VaccinationCenter center  = centerRepo.findById(id).get();
		requiredResponse.setCenter(center);
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CitizenServer/citizen/vacc_id/"+id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return requiredResponse;
	}
}