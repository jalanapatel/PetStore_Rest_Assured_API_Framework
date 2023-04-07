package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

/*  Data Provider method get Data from ExcelSheet, and provides data to another test method/testcase.
	                     Data provider method get entire data from ExcelSheet and store data into two Dimensional Array. 
	                     testMethod/testCase repeat multiple time, depend on data, which provides, by data provider method.(without loop statement i.e advantage of ExcelUtility)

     for Data Provider method: Use "@DataProvider Annotations" ---> Generate Data and Passing data to test methods
     
     System.getProperty("user.dir") --> Gives Current Project Location
*
*/



public class Data_Providers {
	
	
	
// Get All Data from Excel Data from ExcelSheet
	
	@DataProvider(name = "Data")
	public String [][] getAllData () throws IOException
	{
	    String xl_path = System.getProperty("user.dir") + "//TestData//userData.xlsx";
		
		
		Excel_Utility xl = new Excel_Utility(xl_path);
		
		int rownum = xl.getRowCount("Sheet1");                       // Get Total no of rows
		int colcount = xl.getCellCount("Sheet1",1);                  // Get Total no of Cols
		
		String apidata[][] = new String [rownum][colcount];          // Create two Dimensional Array to Store Data and same as Excel nofRows and noofCols
		
		for ( int i=1; i<=rownum; i++)
		{
			for (int j=0; j<colcount; j++)
			{
				apidata[i-1][j] = xl.getCellData("Sheet1",i,j);
			}
		}
		
		return apidata;
		
	}
	
	

// Get only UserNames from ExcelSheet
	
	@DataProvider (name="UserNames")
	public String [] getUserNames () throws IOException
	{
		
		 String xl_path = System.getProperty("user.dir") + "//TestData//userData.xlsx";
		
		
		
		Excel_Utility xl = new Excel_Utility(xl_path);
		
		int rownum = xl.getRowCount("Sheet1");
		
		String apidata_UserName [] = new String [rownum];
		
		for (int i=1; i<=rownum; i++)
		{
			apidata_UserName [i-1] = xl.getCellData("Sheet1",i,1);
		}
		
		return apidata_UserName;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
