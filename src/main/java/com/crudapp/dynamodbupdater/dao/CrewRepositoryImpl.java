package com.crudapp.dynamodbupdater.dao;

import java.util.List;

import com.crudapp.dynamodbupdater.model.CrewDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.crudapp.dynamodbupdater.model.CrewEntity;

@Repository
public class CrewRepositoryImpl implements CrewRepository {

	@Autowired
	private DynamoDBMapper mapper;

	@Autowired
	@Qualifier("mapperConfigProfile")
	private DynamoDBMapperConfig mapperConfig;

	public CrewEntity saveCrew(CrewEntity entity) {
		System.out.println("Inside save Crew Profile method");
		try {
			mapper.save(entity, mapperConfig);
		} catch (Exception e) {
			System.out.println("error occured :" + e.getMessage());
			System.out.println(e);
			throw e;
		}

		System.out.println("Data is Sucessfully Updated in table ");
		return entity ;

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


	public CrewEntity updateCrew(String id, CrewDTO dto) {
		CrewEntity crew = mapper.load(CrewEntity.class, id,mapperConfig);
		BeanUtils.copyProperties(dto, crew);

		mapper.save(crew);

		return crew;
	}



}
