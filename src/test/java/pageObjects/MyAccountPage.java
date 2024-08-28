package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	//constructor
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	  //element location
	

@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement myAccount;
	


@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement logout;
            	//actions
	
public boolean  verifyAcount() {
	
	try {
	
		return(myAccount.isDisplayed());
}
	
	catch(Exception e ) {
	
	return false;
	}
}

public void clickLogout() {
	logout.click();
	}





}
