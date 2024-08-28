package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {  //parent cls of all pageobjects

	WebDriver driver;	
	
	//constructor (access all packages in projects thats why use public keyword below

public BasePage(WebDriver driver) {

	this.driver=driver;
	PageFactory.initElements(driver,this);
}
}