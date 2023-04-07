package api.endpoints;

import static io.restassured.RestAssured.*;

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






public class A2_UserEndPoints {

	
	
// Create User 
	
	public static Response createUser(A3_User_Payload  payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)

				.when().post(A1_Routes.post_url);

		return response;
	}
	
	
// Retrieve / Read User
	
	public static Response readUser(String username) {

		Response response = given()
				             .pathParam("username", username)

				.when()
				.get(A1_Routes.get_url);

		return response;
	}
	
	
// Update User
	
	public static Response updateUser(String username, A3_User_Payload payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)

				.when().put(A1_Routes.update_url);

		return response;
	}
	
	
// Delete User
	
	public static Response deleteUser(String username) {

		Response response = given()
				             .pathParam("username", username)

				.when()
				.delete(A1_Routes.delete_url);

		return response;
	}

}
