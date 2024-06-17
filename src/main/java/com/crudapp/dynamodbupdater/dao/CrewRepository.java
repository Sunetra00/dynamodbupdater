package com.crudapp.dynamodbupdater.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.crudapp.dynamodbupdater.modal.CrewEntity;

@Repository
public class CrewRepository {

	@Autowired
	private DynamoDBMapper mapper;

	@Autowired
	@Qualifier("mapperConfigProfile")
	private DynamoDBMapperConfig mapperConfig;

	public boolean saveCrew(CrewEntity entity) {
		System.out.println("Inside save Crew Profile method");
		boolean saveStatus = false;
		try {
			mapper.save(entity, mapperConfig);
		} catch (Exception e) {
			System.out.println("error occured :" + e.getMessage());
			System.out.println(e);
			throw e;
		}
		saveStatus = true;

		System.out.println("Data is Sucessfully Updated in table ");
		return saveStatus;

	}

	public CrewEntity loadCrew(String crewID) {
		System.out.println("Inside loadCrewProfile method");
		CrewEntity crewEntity = null;
		try {
			crewEntity = mapper.load(CrewEntity.class, crewID, mapperConfig);
		} catch (Exception e) {
			System.out.println("error occured :" + e.getMessage());
			System.out.println(e);
			throw e;
		}
		return crewEntity;

	}

	public List<CrewEntity> loadAllCrews() {
		System.out.println("Inside loadCrewProfile method");
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

		List<CrewEntity> crews = mapper.scan(CrewEntity.class, scanExpression);
		return crews;

	}

	public boolean deleteCrew(String crewid) {
		System.out.println("Inside save Crew Profile method");
		boolean saveStatus = false;
		try {
			CrewEntity entity = loadCrew(crewid);
			if (entity != null) {
				mapper.delete(entity, mapperConfig);
			}
		} catch (Exception e) {
			System.out.println("error occured :" + e.getMessage());
			System.out.println(e);
			throw e;
		}
		saveStatus = true;

		System.out.println("Data is Sucessfully Updated in table ");
		return saveStatus;

	}
	
	
	public boolean deleteCrew(String crewId,String updateKey, String updateVal) {
		System.out.println("Inside save Crew Profile method");
		boolean saveStatus = false;
		try {
			CrewEntity entity = loadCrew(crewId);
			if (entity != null) {
				saveCrew(entity);
			}
		} catch (Exception e) {
			System.out.println("error occured :" + e.getMessage());
			System.out.println(e);
			throw e;
		}
		saveStatus = true;

		System.out.println("Data is Sucessfully Updated in table ");
		return saveStatus;

	}

}
