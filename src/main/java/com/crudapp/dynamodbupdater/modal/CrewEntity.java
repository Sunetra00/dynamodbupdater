package com.crudapp.dynamodbupdater.modal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

public class CrewEntity {
	
	@DynamoDBHashKey
	private String crewid;
	@DynamoDBAttribute
	private String name ;
	public String getCrewid() {
		return crewid;
	}
	public void setCrewid(String crewid) {
		this.crewid = crewid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
