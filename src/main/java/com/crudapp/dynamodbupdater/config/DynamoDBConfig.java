package com.crudapp.dynamodbupdater.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride;

@Configuration
public class DynamoDBConfig {
	
		@Value("${table.crew}")
		private String profileTableName;
	 
		@Primary
		@Bean
		public DynamoDBMapper getdynamoDBMapper() {
	 
			return new DynamoDBMapper(buildAmazonDynamoDB());
		}
	 
		@Bean(name = "amazonDynamoDB")
		public AmazonDynamoDB buildAmazonDynamoDB() {
			return AmazonDynamoDBClientBuilder.defaultClient();
		}
	 
		@Bean(name = "mapperConfigProfile")
		public DynamoDBMapperConfig buildMapperConfigForProfile() {
	 
			return DynamoDBMapperConfig.builder()
//					.withTableNameOverride(new TableNameOverride(profileTableName))
					.withSaveBehavior(SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build();
	 
		}
}
