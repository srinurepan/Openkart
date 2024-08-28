package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	             //constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
        //locators


@FindBy(xpath="//input[@id='input-firstname']") 
WebElement 	TxtfirstName;
@FindBy(xpath="//input[@id='input-lastname']") 
WebElement 	TxtlastName;
@FindBy(xpath="//input[@id='input-email']") 
WebElement 	TxtMail;
@FindBy(xpath="//input[@id='input-telephone']") 
WebElement 	Txttelephone;
@FindBy(xpath="//input[@id='input-password']") 
WebElement Txtpassword;
@FindBy(xpath="//input[@id='input-confirm']") 
WebElement TxtpasswordConfirm;


@FindBy(xpath="//input[@name='agree']") 
WebElement chekBoxagree;

@FindBy(xpath="//input[@value='Continue']") 
WebElement btncontinue;
	    

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
WebElement confirmMsg;
       
         //actions

public void setFirstName(String fname) {
	
	TxtfirstName.sendKeys(fname);
}

public void setLastName(String lname) {
	
	TxtlastName.sendKeys(lname);
}
public void setMail(String mail) {
	
	TxtMail.sendKeys(mail);
}
public void setTelephoneNo(String telNo) {
	
	Txttelephone.sendKeys(telNo);
}
public void setPassword(String pass) {
	
	Txtpassword.sendKeys(pass);
}
public void setConfirmPassword(String pass) {
	
	TxtpasswordConfirm.sendKeys(pass);
}
public void setCheckbox() {
	
	chekBoxagree.click();
}
public void clickButton() {
	
	btncontinue.click();
}

              //if click button not work(no intercepted element errors comes then we 
                   //try below methods

    //1.  btncontinue.submit();
   //2.Actions act=new Actions(driver);
   //act.moveToElement(btncontinue).click().perform();
   //3.btncontinue.sendKeys(Keys.RETURN);
   //4.JavaScriptExecutor js=(JavaScriptExecutor)driver;
   //js.executeScript("arguments[0].click();",btncontinue);
  //5.WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   //wait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
public String getConfirmMessage() {
	try {
		return(confirmMsg.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
}
}