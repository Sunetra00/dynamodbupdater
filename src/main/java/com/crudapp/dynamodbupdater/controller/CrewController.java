package com.crudapp.dynamodbupdater.controller;

import com.crudapp.dynamodbupdater.model.CrewDTO;
import com.crudapp.dynamodbupdater.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crudapp.dynamodbupdater.dao.CrewRepository;
import com.crudapp.dynamodbupdater.model.CrewEntity;
import com.crudapp.dynamodbupdater.model.Response;

import java.util.List;

@RestController
public class CrewController {

	private final CrewService crewService;

	public CrewController(CrewService crewService) {
		this.crewService = crewService;
	}

	@GetMapping("/crews")
	public List<CrewDTO> getAllProducts() {
		return crewService.getAllcrews();
	}

	@GetMapping("/crew/{id}")
	public CrewDTO getCrewById(@PathVariable String id) {
		return crewService.getCrewById(id);
	}

	@PostMapping("/crew")
	public CrewDTO createCrew(@RequestBody CrewDTO productDTO) {
		return crewService.createNewProduct(productDTO);
	}

	@PutMapping("/crew/{id}")
	public CrewDTO updateCrew(@PathVariable String id, @RequestBody CrewDTO crewDTO) {
		return crewService.updateProduct(id, crewDTO);
	}

	@DeleteMapping("/crew/{id}")
	public void deleteProduct(@PathVariable String id) {
		crewService.deleteProduct(id);
	}


}


