package Rest_Assured_PetStore_API_Framework_Project;

public class A1_Rest_Assured_API_Framework {

	public static void main(String[] args) {
		
		/*
		
		FrameWork Development / Framework Design Development
		-------------------------------------------------------
		
		Framework: maintain all project related files.
		
		Objectives: Re-usability, Maintainability, Readability
		
		framework in RestAssured is maintain different types of files, testcases, different URL, endpoints, POJO, 
		DataDriven test cases, reports.
		
		Main Objective is to maintain framework is re-useability, so same component is reusable for multiple time
		and easy to maintain and easy to read and understand
		
		Suppose we design framework, and need to update and add new code in existing framework, 
		then we can do easily without disturbing current functionality. 
		
		here, Type of framework is Hybrid Driven Framework ---> combination of DataDriven and KeyDriven/Modular Framework
		
		
		Phases of Designing and Development of Automation Framework:
		----------------------------------------------------------------
		
		1). UnderStanding Requirement very Clearly -- what kind of request, type of response, type of URL
		     --> Functional Specification (it is Static Documentation)
		     --> Swagger Docs(Interactive Documentation -- along with URL, type of request, type of response)
		     
		2). Choose Automation Tools --> Rest Assured Library
		     ---> Rest Assured is not tool. 
		     ---> (Rest Assured is Library, Selenium is also  Library -- which contain jar files, along with classes and method)
		     
		3). Design Framework -- Folder Structure, Files created, how we can manage all Documents
		
		4). Development
		
		5). Implement and Execution with CI / CD
		     
		
		
		URL: for PetStore API.
		 ---> https://petstore.swagger.io/   ---> three module are available (Pet module, Store module, user module) Operations about user
		 
		 first create Test case.
		 in real project, we receive Functional Specification Documents or swagger Docs --> along with Url, feature and type of request to send (.get, .post, .put, .delete)
		 , type of data send along with request and type of response received, endPoints
		 
		 
		here we take four request
		
		GET -- get user Detail - by username
		PUT -- Update User - by username
		DELETE -- Delete User - by username
		POST -- Create User 
		
		It is recommended at least execute once in Postman tool, then try to automate testcase.
		
		As we can see entire Frame work divide in three Parts:
		--> Development
		--> Execution
		--> CI: Continuous Integration i.e Push Code in Remote Repository and Run through Jenkins
		
	
	once we develop and then execution successfully, then CI.
	
	In Development, we maintain Endpoints for every module different Endpoints, create multiple Package for routes, UserEndpoints, Store endpoints, petendpoints
	i.e maintain all endpoints in single packeage with different classes.
	
	Before endpoints, we have routes, and 
	routes is single class where maintain all URL for all modules.
	each endpoints have implementation of particular requests.
	ie endpoints includes pre-request and request type.
	TestCase include validation
	
	routes called by testcases and TestCase include validation and testNG.xml will execute testcase and later run through pom.xml and pom.xxml include required dependency.
	
	PayLoads: for every module, there is Payloads, for Example: Post request,  required some data ( request Body), as part of request,  to create new record. 
	(Data can be prepared multiple ways POJO, Json, HasMap i.e many ways we can create request Body.)
	
	PayLoads is Create Request Body, POJO is very commons i.e maintain POJO Class as Payloads i.e User related POJO Class, Store related POJO class, Pet related POJO class.
	
	Utilities: it is required specially Data Driven Testing, like Data providers utility in TestNG, Extent Report utility, Excel utility.
	
	TestData: Data required for input, and TestData maintain in Excel file for Ex: UserData.xlsx, StoreData.xlsx, PetData.xlsx
	
	Reports: Generate Different Reports by running TestNG.xml or pom.xml file, like TestNG Reports, Extent Reports. 
	
	So here we complete Development and Execution of API. 
	
	After that once completion, Push entire Code into Git and GitHub and finally Run through Jenkins (CI Process)
	
	(We can also add logging mechanism here Like - Log4j or other logging method (.logall() method)to print message based on response)
	
	Log is very helpful to debug code when failure is happened. 
	
	
	**********************************************************************************************************************************
	
	In many framework, use properties file as  separate files is used to maintain routes URLs - (Endpoints) instead of in routes class
	as flow diagram of 2	
	
	In Properties files maintain routes and Url's. so, from properties file get all URL and used in Endpoints class.
	
	
	**********************************************************************************************************************************
	
	
	Use Maven Project always: 
	
	src/main/java and src/main/resources use by Developer to write main code and Unit testing is performed by Developer. and testcase for Unit testing keep in src/test/java
	 
	src/main/java -- developed main code by developer
	src/main/resources -- store resource required for developer to develop code. 
	
	(Resources are properties file, xml file, Excel file or other external file for development purpose.)
	
	
	src/test/java - Unit testing testcase
	src/test/resources -- store resources files which requires, to write testcase.
	
	**********************************************************************************************************************************
	
	pom.xml has two types of Entry: Dependency (required jar files) and Plugins ( complie and executing Project )
	
	src/test/java --->  here, Create Different Package 
	              --->   api.endpoints -- maintain endppoint (routes), 
	                     api.payload - maintain POJO, 
	                     api.test - maintain testcase, 
	                     api.utilities - excel utility, extent utility -- Reusable component
	                     
	
	src/test/resources ---> maintain properties like routes --> routes.properties file --> used for end URL's. 
	
	Apart from this testNG.xml file and pom.xml file and testData file like - Userdata.xlsx
	
	also, Create Report Folder: to maintain reports.
	
	*************************************************************************************************************************
	
	
	Pre-requisites are as below:
	
	
	STEP:01 Create Maven Project
	
	STEP:02 Update pom.xml with required Dependency and Maven Update Project
	
	    ---> Now, Actual Development Start and basic Structure component create i.e create different Package and folder structure. see in flowdiagram pics
	    ---> ( like Endpints, TestCases, PayLoads, Utilities, TestData, TestNg.xml, pom.xml, Reports ) 
	
	
	STEP:03 Create Folder Structure ---> very very important and create Package in src/test/java
	
	*************************************************************************************************************************************
	
	Development Start here: To create Test cases, we required, endpoints (routes), payloads, utilities, TestData
	
	          
	
	STEP:04 Creates Route.java class file.   ---> Maintains URL Only.
	   
	     by using routes implements endpoints.
	

    STEP:05 Create EndPoints for UserModule --> create and implement method to send url request -- CRUD Methods implementations
            
            CRUD --> Create, Retrieve/Read, Update, Delete
	
	STEP:06 Create TestCases in api.test Package
	
	STEP:07 Create Data Driven Test (api.test)
	               --> Maintain Data into ExcelSheet
	               --> Use Apache POI -- Third Party tool 
	               --> Maintain Excel Utility File
	               --> Create Data Provides method and keep into Utility: -- Data Provider method get Data from ExcelSheet, and provides data to another test method/testcase.
	                     Data provider method get entire data from ExcelSheet and store data into two Dimensional Array. 
	                     testMethod/testCase repeat multiple time, depend on data, which provides, by data provider method.(without loop statement i.e advantage of ExcelUtility)
	
	  
	STEP:08 Generate Extent Report Using Extent Report Utility
	                ---> TestNg.xml file is required (along with Extent Report Utility class)
	                ---> Extent utility use, inside testNG.xml file ( without testNG.xml file, cannot generate Report )
	                ---> To Generate Report, run TestCases (from api.test package) using testNG.xml file
	
	
	STEP: 09 Add Logs
	            --> Add Log4j2 Library -- Third Party Library (Tool)
	            --> Add Log4j2 dependency in pom.xml file 
	            --> Create Log4j2.xml configuration file in src/test/resources folder ( or Create Property file )
	            
	            (NOTE: Create Properties File and keep all routes (URL) i.e routes.properties and instead of writing routes in one class, and refer routes class  in Endpoint class, 
	                   Create routes.property file, in properties/Utilities and keep in resources folder and keep all URL in routes.properties file 
	                   and  those URL (from routes.properties file) refer/read  into UserEndPoints )
	

	STEP: 10 Write Code to Generate Logs in Test Case - A6_UserTests_Logs.java class
	
	STEP: 11 Test Execution -- Two ways by testNG.xml file and pom.xml file
	                        ---> testNG.xml run test case run directly from file locally
	                        ---> pom.xml run testcase remotely by Jenkin Tool or command prompt then must be use pom.xml file
	                        ---> we need to add dependency/plugins in to pom.xml file (maven-surefire-plugin and maven-compiler-plugin)
	                      
	                        ---> Update project as maven --> build project 
	                      
	                        ---> run testng.xml through pom.xml file 
	                        ---> run pom.xml ( as maven test ) --> run testng.xml --> execute class mention in testng.xml
	                        ---> Run project through command prompt and remotely through Jenkin. 
	
	STEP:12 Run pom.xml remotely (without Eclipse) by Jenkins.
	        ---> Before run project in Jenkins, Script/Code run by using command Propmt (mvn test command) ( without eclipse )
	        
	        1). Execute tests using pom.xml within eclipse, if project executed here, then only we can run through command prompt. 
				If the project fails here, then we cannot perform the next steps. 
				
			2). Execute test using pom.xml in command prompt, using “maven test “or “maven clean test "command 
				If a project executes successfully in maven command, then only we can run the project remotely through Jenkins. 
				( Jenkin also use same “maven test” command ) 
			
				Run project in following sequence: 
a).			
 ---> run pom.xml in Eclipse manually ---> run pom.xml in command prompt in local machine ---> run project in Jenkins remotely
	
b). 	
 ---> run pom.xml in Eclipse manually ---> run pom.xml in command prompt in local machine ---> commit in Local repository (Git)--- 
 
 ---> Local machine ---> commit code ---> Git (Local repository) ---> push code ---> GitHub (Remote repository)
 
 --> Create build in deveops environment ---> run project in Jenkins remotely
	
	
	         3).Commit code in Local Repository ( Git )
	         
	         4). Push Code into Remote Repository / Global Repository( GitHub )
	         
	         5). Run Project in Jenkins ( from GitHub ) ( Latest Code - every day change code ) 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
	 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
