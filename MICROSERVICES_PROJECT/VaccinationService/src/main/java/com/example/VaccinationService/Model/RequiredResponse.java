package com.example.VaccinationService.Model;

import java.util.List;

import com.example.VaccinationService.Entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequiredResponse {
	private VaccinationCenter center;
	private List<Citizen> citizens;
}