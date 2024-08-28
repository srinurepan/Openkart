package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j Manager
import org.apache.logging.log4j.Logger;    //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {  //parent cls of all testclses

public	 static WebDriver driver;
public Logger logger;
public Properties p;

   
	@BeforeClass(groups= {"Sanity","Master","Regression","datadriven"})
    @Parameters({"os","browser"})
	public void setUp(String os,String  br) throws IOException {
		
		
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//Config.properties");
		p=new Properties();
		p.load(file);  
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge"   :  driver= new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default :System.out.println ("Invalid browser name"); return;
		}
		
	//	driver = new ChromeDriver();
		
	 driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL")); //Reading url from properties file
	
		driver.manage().window().maximize();


	}
	@AfterClass	(groups= {"Sanity","Master","Regression"})
	public void tearDown() {

	driver.quit();
	}


	


//Randomly get alphabets,numeric values alternatively


public String randomeString() {
	   
	       String generatedstring = RandomStringUtils.randomAlphabetic(5);

	       return generatedstring;
}

  //get RandomNumericValues(ex=1213457)

public String randomNumber() {
	
	   String generateNumber = RandomStringUtils.randomNumeric(10);
	   return generateNumber;
	   
}

//get both randomNumbers and alphabets(ex:123asdsf)

public String randomeAlphaNumbric() { 
	
	  String generatedstring = RandomStringUtils.randomAlphabetic(5);
	  String generatednumber = RandomStringUtils.randomNumeric(4);
	 
	  return (generatedstring +"@"+ generatednumber);
	   
}

    public String captureScreen(String tname)throws IOException {
		
    	String timeStamp =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	
    	TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
    	File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +  "_"  + timeStamp + ".png" ;   
    	File targetFile=new File(targetFilePath);
    	
    	sourceFile.renameTo(targetFile);
    	return targetFilePath;
    	
    	
    	
    	
    }



}
