package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report_Manager implements ITestListener

{
		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent;
		public ExtentTest test;
		
		String repName;
		
		public void onStart(ITestContext testContext)
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());        //timeStamp
			
			repName = "Test-Report-" + timeStamp + ".html";
			
			
			// ExtentSparkReporter -- Look and Feel of Report
			
			
			sparkReporter = new ExtentSparkReporter(".\\Reports\\" + repName);                     // Specify location of Report
			
			sparkReporter.config().setDocumentTitle("Rest Assured Automation Project");            // Title of Report
			sparkReporter.config().setReportName("Pet Store Users API.");                         // Name of Report
			sparkReporter.config().setTheme(Theme.DARK);
			
			
			// ExtentReports -- Specify Common Information
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "Pet Store Users API");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("user","Jammy");

		}
	  
		
		   // ExtentTest -- Specify Entry for Pass, Fail, Skip Report.
		  
		
		public void onTestSuccess (ITestResult result)
		{
			test = extent.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.createNode(result.getName());
			test.log(Status.PASS, "Test Passed");
		}
		
		
		public void onTestFailure (ITestResult result)
		{
			test = extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test Failed");
			test.log(Status.FAIL, result.getThrowable().getMessage());
		}
		
	
	    public void onTestSkipped (ITestResult result)
	    {
	    	test = extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test Skipped");
			test.log(Status.SKIP, result.getThrowable().getMessage());
	    }
	
	
	    public void onFinish (ITestContext testContext)
	    {
	    	extent.flush();                                      // .flush() method is very important -- which generate report.-- Writes test information 
	    }


}
