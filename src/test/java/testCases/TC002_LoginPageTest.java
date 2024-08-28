package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Baseclass;

public class TC002_LoginPageTest extends Baseclass {

	
	@Test(groups= {"Sanity","Master"})
	public void verifyLogin() {
		
		logger.info("**** testcase2 started*****");
		
		try {
		
		HomePage hp=new HomePage(driver);
		
		//homepage
		hp.clickMyAccount();
	     hp.clickLogin();
	     
	     //loginpage
	     LoginPage lp=new LoginPage(driver);
	     
	     lp.setEmail("abc123@gmail.com");
	     lp.setpassword("test@123");
	     lp.Click();
	     
	     //my account page
	     
	     MyAccountPage map=new MyAccountPage(driver);
	     
	     boolean loginValidity = map.verifyAcount();
	     
	     Assert.assertTrue(loginValidity);
	      
	             //or
	     
	//     Assert.assertEquals(loginValidity, true," login failed");
	    
		}
		
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("**** Testcase2 finished");
		
	}
	
	
}
