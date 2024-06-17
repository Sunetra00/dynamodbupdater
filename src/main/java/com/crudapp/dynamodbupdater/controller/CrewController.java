package com.crudapp.dynamodbupdater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.dynamodbupdater.dao.CrewRepository;
import com.crudapp.dynamodbupdater.modal.CrewEntity;
import com.crudapp.dynamodbupdater.modal.Response;

@RestController
public class CrewController {
	
	@Autowired
	CrewRepository crewRepository;
	
	@PostMapping("/crew/add")
	ResponseEntity<Response> postcrew(@RequestBody CrewEntity crewEntity){
		boolean status=crewRepository.saveCrew(crewEntity);
		ResponseEntity<Response> response = buildResponse(status,crewEntity);
		return response;
	}

	private ResponseEntity<Response> buildResponse(boolean status ,CrewEntity crewEntity) {
		// TODO Auto-generated method stub
		Response response=new Response();
		response.setStatus(String.valueOf(status));
		response.setStatusCode("200");
		response.setEntity(crewEntity);
		return new ResponseEntity<Response>(response, HttpStatusCode.valueOf(200));
	}
	
	
}
