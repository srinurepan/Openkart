package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path=".\\testData\\openkart.xlsx"; // taiking xl file from testData folder
		
		ExcelUtils xlutil=new ExcelUtils(path); //creating object for ExcelUtils cls
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		
		String loginData[][]=new String[totalrows][totalcols]; //created for two dimensional array which can store
		
		for(int i=1;i<=totalrows;i++) {              //1 //read data from xl storing in two dimensional array
			
			for(int j=0;j<totalcols;j++) {     //0  // i means is rows  & j means cols
				
		loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);  //1,0
		
			}
			
	}
		return loginData;  //returning two dimensional array
		
		
	}
	

	
	//if we are more dataproviders use similarly  above type
		
		 // DataProvider 2
	   
	
	    // DataProvider 3
	
	    // DataProvider 4

}
