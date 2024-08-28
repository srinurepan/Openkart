package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	       //constructor
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	       //elements locators
	

@FindBy(xpath="//input[@id='input-email']") 
WebElement eMailAddress;
@FindBy(xpath="//input[@id='input-password']") 
WebElement password;
@FindBy(xpath="//input[@value='Login']")
WebElement login;
	
	 //actions

public void setEmail(String mail) {
	eMailAddress.sendKeys(mail);

}

public void setpassword(String pass) {
	password.sendKeys(pass);

}


public void Click() {
	login.click();;

}


}
