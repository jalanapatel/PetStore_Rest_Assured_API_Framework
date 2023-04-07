package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.A2_UserEndPoints;
import api.payloads.A3_User_Payload;
import io.restassured.response.Response;

public class A4_UserTests {
	
	// Create Data for Post request
	
	Faker faker;
	A3_User_Payload userPayload;
	
	
	
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

	}

	
// Create User Test
	
	@Test (priority = 1)
	public void testPostUser()
	{
		Response response = A2_UserEndPoints.createUser(userPayload);	
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	

	
// Get User By UserName
	
	@Test (priority = 2)
	public void testGetUserByName ()
	{
		Response response = A2_UserEndPoints.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);

	}
	
	
	
// Update User by UserName  -- FirstName, LastName, Email
	
	@Test (priority = 3)
	public void testUpdateUserByName ()
	{
		// Update data using payload
		
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
	    userPayload.setEmail(faker.internet().safeEmailAddress());
		
	    Response response = A2_UserEndPoints.updateUser( this.userPayload.getUsername(), userPayload);
	    
	    response.then().log().body();
	    
	    
	            //    response.then().log().all();
	    
	            //    response.then().log().body().statusCode(200);
	    
	            //   Assert.assertEquals(response.getStatusCode(),200);
	    
	    
	    // Checking data after Update
	    
	    
	    
	    Response responseAfterUpdate = A2_UserEndPoints.readUser(this.userPayload.getUsername());
		
	    responseAfterUpdate.then().log().all();
		
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

		
	}
	
	
	@Test (priority = 4)
	public void testDeleteUserByName() 
	{
		Response response = A2_UserEndPoints.deleteUser(this.userPayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
