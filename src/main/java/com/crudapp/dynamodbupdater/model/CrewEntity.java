package com.crudapp.dynamodbupdater.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "crewinfo")
public class CrewEntity {
	
	@DynamoDBHashKey
	private String crewid;
	@DynamoDBAttribute
	private String firstName ;

	@DynamoDBAttribute
	private String lastName ;

	@DynamoDBAttribute
	private String nickname ;

	@DynamoDBAttribute
	private String city ;

	@DynamoDBAttribute
	private String rank ;
	

}
