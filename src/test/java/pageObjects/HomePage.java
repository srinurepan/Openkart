package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage  {

	     //constructor
	
	// WebDriver driver;	

public HomePage(WebDriver driver) {

   super(driver);
}

         //locators



@FindBy(xpath="//span[@class='caret']") 
WebElement myAccount;
@FindBy(xpath="//a[normalize-space()='Register']")
WebElement register;


@FindBy(xpath="//a[normalize-space()='Login']") 
WebElement login;

       //actions



public void clickMyAccount() {
	myAccount.click();
}

public void clickRegister() {
	register.click();
	
}

public void clickLogin() {
	login.click();
	

}
}