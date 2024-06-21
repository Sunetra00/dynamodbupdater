package com.crudapp.dynamodbupdater.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
public class CrewDTO {
    private String crewid;
    private String firstName;
    private String lastName;
    private String nickname;
    private String city;
    private String rank;
}
