package api.endpoints;


/*  In Routes Class : Maintain URL only.
 
 * here we get all URL from Swagger.
 * 
 * URL --> Base URL + EndPoint + pathPameter
 * 
 * Base URL :  https://petstore.swagger.io/v2
 * EndPoint :  /user/
   pathPameter : {username}
   
   
 * Main URL :  https://petstore.swagger.io
 
  
 * Swagger URL --->  https://petstore.swagger.io
 
 
 * Create User (post): https://petstore.swagger.io/v2/user
 * Get User (Get) : https://petstore.swagger.io/v2/user/{username}
 * Update User (Put) : https://petstore.swagger.io/v2/user/{username}
 * Delete user (Delete) : https://petstore.swagger.io/v2/user/{username} 
 
 */


public class A1_Routes {

	/*  In Routes Class : Maintain URL only.*/
	
                                                                     // Create base URL
	
	public static String base_url = "https://petstore.swagger.io/v2";    // Public -- use url -- access URL everywhere in project.
	                                                                      // static -- use base_url variable with className, without Creating object of class
	                                                                     // base_url -- variable of String type
	
	
	    // User Module  ---> Creates Endpoint for User Module
	
	public static String post_url = base_url + "/user";
	
	public static String get_url = base_url + "/user/{username}";
	
	public static String update_url = base_url + "/user/{username}";
	
	public static String delete_url = base_url + "/user/{username}";
	
	
	
	
	
	
	
	
	
	
	
	
}
