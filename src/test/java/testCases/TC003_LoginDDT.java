package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Baseclass;
import utilities.DataProviders;

// data is valid --- login success ->test pass -logout
//data is valid  --- login failed -> test fail

//data is invalid---login success -> test fail --logout
//data is invalid---login failed  -> test pass

public class TC003_LoginDDT extends Baseclass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="datadriven") //getting data provider from different cls
	
	public void verifyLogin_DDT(String email,String pwd,String exp) {
		
	logger.info("******* Starting TC003_loginDDT ******");
		
		
try {
		
		//homepage
	HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
	     hp.clickLogin();
	     
	     //loginpage
	     LoginPage lp=new LoginPage(driver);
	     
	     lp.setEmail(email);
	     lp.setpassword(pwd);
	     lp.Click();
	     
	     //my account page
	     
	     MyAccountPage map=new MyAccountPage(driver);
	     
	     boolean loginValidity = map.verifyAcount();
	     
	   
	
	// data is valid --- login success ->test pass -logout
	//data is valid  --- login failed -> test fail

	//data is invalid---login success -> test fail --logout
	//data is invalid---login failed  -> test pass

if(exp.equalsIgnoreCase("valid")) {
	if(loginValidity==true) {
		
		map.clickLogout();
		Assert.assertTrue(true);
		
	}
	
	else {
		
		Assert.assertTrue(false);
		
		
	}
	
}

if(exp.equalsIgnoreCase("invalid")) {
	
	if(loginValidity==true) {
		
		map.clickLogout();
		Assert.assertTrue(false);
		
	}
	else {
		
		Assert.assertTrue(true);
		
		
	}
}


}  catch(Exception e) {
	
	Assert.fail();
}
logger.info("******* finished TC003_loginDDT ******");
		}
	
	}
	

	
	
	

