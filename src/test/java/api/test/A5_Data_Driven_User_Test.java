package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.A2_UserEndPoints;
import api.payloads.A3_User_Payload;
import api.utilities.Data_Providers;
import io.restassured.response.Response;

/*
   Data Driven Testing:
     --> Create multiple USER, by sending post request multiple times
     --> once created, delete all user by passing userName.
   
   here, Created two DataProvider method, to create multiple user and other for delete user 
   --> To create multiple user: pass entire data by using post request.
   --> delete user: from database delete user, from excel sheet use only userName and pass userName as input to delete request.
  
 */

public class A5_Data_Driven_User_Test {
	
	
	
	// POST Request for Multiple User i.e create multiple user -- get data from DataProvider method, create Payload and create user
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = Data_Providers.class)
	public void testPostUser(String userID, String userName, String firstName, String lastName, String email, String password, String phone )
	{
		
		A3_User_Payload userPayload = new A3_User_Payload();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstname(firstName);
		userPayload.setLastname(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		
		
		Response response = A2_UserEndPoints.createUser(userPayload);
	
	    Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	
	// Delete Users, by using UserName, which are created in First request.
	
	
	@Test (priority = 2, dataProvider = "UserNames", dataProviderClass = Data_Providers.class)
	public void testDeleteUserByName(String userName)
	{
		
		Response response = A2_UserEndPoints.deleteUser(userName);
		
		Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
