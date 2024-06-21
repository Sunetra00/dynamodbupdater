package com.crudapp.dynamodbupdater.model;

import com.crudapp.dynamodbupdater.dto.CrewDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"status",
		"statuscode",
		"operationType",
		"requestedCrewId",
		"crews"
})
public class ResponseModel {
	@JsonProperty("requestedCrewId")
	private String requestedCrewId;
	@JsonProperty("operationType")
	private String operationType;
	@JsonProperty("status")
	private String status;
	@JsonProperty("statuscode")
	private String statusCode;
	@JsonProperty("crews")
	private List<CrewDTO> crews = new ArrayList<>() ;


	
	
	
}
