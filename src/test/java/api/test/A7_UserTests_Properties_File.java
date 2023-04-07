package api.test;



// refering properties file for URL and use A21_UserEndPoints_PropertiesFile Class

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.A21_UserEndPoints_PropertiesFile;
import api.endpoints.A2_UserEndPoints;
import api.payloads.A3_User_Payload;
import io.restassured.response.Response;

public class A7_UserTests_Properties_File {
	
	// Create Data for Post request
	
	Faker faker;
	A3_User_Payload userPayload;
	
	public Logger logger;                 // For Logs
	
	
	
	@BeforeClass
	public void setupData() 
	{
		
		faker = new Faker();
		userPayload = new A3_User_Payload();
		
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		
		// Write Code to Initiate Logs
		
		logger = LogManager.getLogger(this.getClass());
		
	
	}

	
// Create User Test
	
	@Test (priority = 1)
	public void testPostUser()
	{
		
		logger.info(" ************  Creating User ************** ");
		
		Response response = A21_UserEndPoints_PropertiesFile.createUser(userPayload);	
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info(" ************  Creating User ************** ");
	}

	

	
// Get User By UserName
	
	@Test (priority = 2)
	public void testGetUserByName ()
	{
		logger.info(" ************  Reading User Info  ************** ");
		
		Response response = A21_UserEndPoints_PropertiesFile.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info(" ************   User Info Displayed ************** ");

	}
	
	
	
// Update User by UserName  -- FirstName, LastName, Email
	
	@Test (priority = 3)
	public void testUpdateUserByName ()
	{
		
		logger.info(" ************  Updating User ************** ");
		
		
		// Update data using payload
		
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
	    userPayload.setEmail(faker.internet().safeEmailAddress());
		
	    Response response = A21_UserEndPoints_PropertiesFile.updateUser( this.userPayload.getUsername(), userPayload);
	    
	    response.then().log().body();
	    
	    
	            //    response.then().log().all();
	    
	            //    response.then().log().body().statusCode(200);
	    
	            //   Assert.assertEquals(response.getStatusCode(),200);
	    
	    logger.info(" ************  User Updated ************** ");
	    
	    
	    
	    // Checking data after Update
	    
	    
	    
	    Response responseAfterUpdate = A21_UserEndPoints_PropertiesFile.readUser(this.userPayload.getUsername());
		
	    responseAfterUpdate.then().log().all();
		
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

		
	}
	
	
	@Test (priority = 4)
	public void testDeleteUserByName() 
	{
		logger.info(" ************  Deleting User ************** ");
		
		Response response = A21_UserEndPoints_PropertiesFile.deleteUser(this.userPayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info(" ************  User Deleted  ************** ");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
