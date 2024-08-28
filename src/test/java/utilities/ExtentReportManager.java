package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Baseclass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent;              //populate common info on the report
    public 	ExtentTest test; // creating test case entries in the report & update status of the test methods

    String repName;
    
	public void onStart(ITestContext testContext) {
		
	/*	SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);
	*/	
		            //or
		
		String timestamp=new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date()); //time stamp
		
		repName="Test-Report-" + timestamp + ".html";
		
sparkReporter= new ExtentSparkReporter(".\\reports\\" + repName); //specify location of the report
		
 sparkReporter.config().setDocumentTitle(" Openkart Automation Report"); //Title of report
sparkReporter.config().setReportName("Openkart Functional Testing");   //name of the report
 sparkReporter.config().setTheme(Theme.DARK);   //or STANDARD
	 
	  extent =new ExtentReports();
	  extent.attachReporter(sparkReporter);
	
	extent.setSystemInfo("Application", "openkart");
	extent.setSystemInfo("module","Admin");
	extent.setSystemInfo("Sub Module","Customers");
	extent.setSystemInfo("User Name",System.getProperty("user.name"));
	extent.setSystemInfo("Environment","QA");
	
	String os=testContext.getCurrentXmlTest().getParameter("os");
	extent.setSystemInfo("Operating System", os);
	
	String browser=testContext.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browser", browser);
	
	
	List<String> includeGroups=testContext.getCurrentXmlTest().getIncludedGroups();
	if(!includeGroups.isEmpty()) {
		extent.setSystemInfo("Groups", includeGroups.toString());
	}
	
	}
	
	
	
	
	public void onTestSuccess(ITestResult result) {
	   
		test=extent.createTest(result.getTestClass().getName()); //create a new entry in the report
		test.assignCategory(result.getMethod().getGroups());   //to diplay groups in report
		test.log(Status.PASS, result.getName()+" got successfully executed");
	  }

	public void onTestFailure(ITestResult result) {
	   
	test=extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.FAIL,  result.getName()+" got failed");	
    test.log(Status.INFO,  result.getThrowable().getMessage());
    
    try {
    	String imgPath=new Baseclass().captureScreen(result.getName());
   test.addScreenCaptureFromPath(imgPath);
    
    } 
    catch(IOException e1) {
    	e1.printStackTrace();
    }
   	
	}

	public void onTestSkipped(ITestResult result) {
	   
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
	
	test.log(Status.SKIP,  result.getName()+" got skipped");
	test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext textContext) {
	    
		extent.flush();
		
		
		//extent reports u want open automatically uncomment below steps
		
/*		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
	 File extentReport=new File(pathOfExtentReport);
	
	 try {
		 
		Desktop.getDesktop().browse(extentReport.toURI()); 
		 
		 } 
	        catch(IOException  e){
			 e.printStackTrace();
		 }
	*/ 
	
	      //u want send reports to someone then use below methods
/*	 
	 try {  URL url=new 
			 
			URL ("file:///"+System.getProperty("user.dir")+"\\reports\\+repName");
	
	 // create the email message
	 
	ImageHtmlEmail email=new ImageHtmlEmail();
	email.setDataSourceResolver(new DataSourceUrlResolver(url));
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("Srinurepan088@gmail.com","password"));
	email.setSSLOnConnect(true);
	email.setFrom("srinurepan088@gmail.com"); //sender
	email.setSubject("Test Result");
	email.setMsg("please find Attached Report....");
	email.addTo("srinurepani123@gmail.com");   //Receiver
	email.attach(url,"extent report","please check report....");
	email.send();  //send the email
	
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	  */
	
	
	
	}    
}





