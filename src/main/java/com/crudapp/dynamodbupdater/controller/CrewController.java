package com.crudapp.dynamodbupdater.controller;

import com.crudapp.dynamodbupdater.dto.CrewDTO;
import com.crudapp.dynamodbupdater.model.RequestModel;
import com.crudapp.dynamodbupdater.model.ResponseModel;
import com.crudapp.dynamodbupdater.service.CrewService;
import org.springframework.web.bind.annotation.*;

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
		return crewService.createNewCrew(productDTO);
	}

	@PutMapping("/crew/{id}")
	public CrewDTO updateCrew(@PathVariable String id, @RequestBody CrewDTO crewDTO) {
		return crewService.updateCrew(id, crewDTO);
	}

	@PostMapping("/ddboperation")
	public ResponseModel ddboperation(@RequestBody RequestModel request) {
		return crewService.doOperation(request);
	}

	@DeleteMapping("/crew/{id}")
	public void deleteCrew(@PathVariable String id) {
		crewService.deleteCrew(id);
	}


}


