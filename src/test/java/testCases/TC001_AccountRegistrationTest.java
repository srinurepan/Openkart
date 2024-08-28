package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Baseclass;

public class TC001_AccountRegistrationTest extends Baseclass {
		

@Test(groups={"Regression","Master"})

public void verifyAccountRegistration()  {
	
	logger.info("**** Starting TC001_ Test");
	
	
	try {
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	
	logger.info("*** Clicked on my account link");
	
	hp.clickRegister();
	
	logger.info("*** clicked on Register link");
	AccountRegistrationPage repPage =new AccountRegistrationPage(driver);
	
  //  Thread.sleep(5000);
	
	logger.info("*** provide customer details");
	
	repPage.setFirstName(randomeString().toUpperCase());
	repPage.setLastName(randomeString().toUpperCase());
	repPage.setMail( randomeString() + "@gmail.com"); //randomly get mail
	
	repPage.setTelephoneNo(randomNumber());
	
	
	String password=randomeAlphaNumbric(); //no90 method stored into "password" varible
	
    repPage.setPassword(password);
    repPage.setConfirmPassword(password);
   
    repPage.setCheckbox();
    repPage.clickButton();
    
    
    logger.info("***** validating expected message");
    
    String AcountConfirmation = repPage.getConfirmMessage();
    
    if(AcountConfirmation.equals("Your Account Has Been Created!")) {
    	
    	Assert.assertTrue(true);
    }
    
    else {
    	logger.error("Test failed");
		logger.debug("debug logs");
	
    	Assert.assertTrue(false);
    }
    
  //  Assert.assertEquals(AcountConfirmation, "Your Account Has Been Created!7");
 
	}
	catch(Exception e){
		
		Assert.fail();
		
		}
	 logger.info("**** Test Finished ****");

	}
 
	

   
}


