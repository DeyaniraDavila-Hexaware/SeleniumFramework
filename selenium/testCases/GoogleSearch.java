package hex.selenium.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import hex.selenium.stepsObjects.DemoQASteps;
import hex.selenium.stepsObjects.GoogleSearchObjects;
import hex.selenium.utilities.DriverHandler;
import hex.selenium.utilities.FindElement;
import hex.selenium.utilities.ReadDatasheet;

public class GoogleSearch {
	// Create a constructor in order to select the driver
	// driverName = Chrome or Edge or Firefox
	public GoogleSearch(String driverName){
		// 1. Tell which Driver to use
		DriverHandler driverHandler = new DriverHandler(driverName);
		
		// Releasing the driver
		// Start the browser
		WebDriver driver = driverHandler.getDriverHandler();
		
		// Start the Script
		try{
			
			// GET DATASHEET
			ReadDatasheet ds = new ReadDatasheet();
			String[][] inputData = ds.readExcelCsv("GoogleSearch.csv");
			
			// Iterate data
			int length = ds.getTotalRows();
			
			for(int i = 1; i < length ; i++ ){
				// Step 1 Navigate
				FindElement.Navigate(driver, "http://www.google.com/");
				
				GoogleSearchObjects.HomePage.SearchTextBox(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_SEARCH"));
				FindElement.Wait(1);
				
				GoogleSearchObjects.HomePage.SearchButton(driver).submit();
				
				FindElement.Wait(3);			
				
			}
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			driver.quit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
