package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payloads.A3_User_Payload;


/*
 *  EndPoints: Create and implement method to send url request -- CRUD Methods implementations
            
   CRUD --> Create, Retrieve/Read, Update, Delete
 * 
 * UserEndPoints.java is create for perform CRUD request to the User API.
 * 
 * Here, we make Public method so we can access method everywhere in Project, with out creating reference object.
 * Static method, we can use with class name, without creating reference object.
 * 
 * here, we create method to create only endpoints and this endpoints we use in testcases.
 * 
 * this methods for endpoint, take Payloads (request Body) ---> from A3_Payload class
 * 
 * 
 * 
 * */






public class A21_UserEndPoints_PropertiesFile {

	
// Write/Create  .getURL() method, to Load Properties File. ( By Using Resource Bundle Class ) --> So refer/getting URL from routes.properties file
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes_URL =  ResourceBundle.getBundle("routes");   // Load and read Propeties file -- return routes_URL as URL 
		return routes_URL;
	}
	

	
	
	
// Create User 
	
		public static Response createUser(A3_User_Payload  payload) {

			// get post Url
			
			String post_url_1 = getURL().getString("post_url");          // .getString("post_url") -- Get Url from Properties file and store into variable "post_url_1"
			
			
			
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)

				.when().post(post_url_1);                            // refer "post_url_1" variable

		return response;
	}
	
	
// Retrieve / Read User
	
	public static Response readUser(String username) {
		
		String get_url_1 = getURL().getString("get_url");            // .getString("get_url") -- Get url frm properties file and store into variable "get_url_1"

		Response response = given()
				             .pathParam("username", username)

				.when()
				.get(get_url_1);

		return response;
	}
	
	
// Update User
	
	public static Response updateUser(String username, A3_User_Payload payload) {
		
		String update_url_1 = getURL().getString("update_url");

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)

				.when().put(update_url_1);

		return response;
	}
	
	
// Delete User
	
	public static Response deleteUser(String username) {

		String delete_url_1 = getURL().getString("delete_url");
		
		
		Response response = given()
				             .pathParam("username", username)

				.when()
				.delete(delete_url_1);

		return response;
	}

}
