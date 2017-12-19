package hex.selenium.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hex.selenium.stepsObjects.DemoQASteps;
import hex.selenium.stepsObjects.GoogleSearchObjects;
import hex.selenium.utilities.DriverHandler;
import hex.selenium.utilities.FindElement;
import hex.selenium.utilities.ReadDatasheet;

public class ToolsQAPractice {
	// Create a constructor in order to select the driver
	// driverName = Chrome or Edge or Firefox
	public ToolsQAPractice(String driverName){
		// 1. Tell which Driver to use
		DriverHandler driverHandler = new DriverHandler(driverName);
		
		// Releasing the driver
		// Start the browser
		WebDriver driver = driverHandler.getDriverHandler();
		
		// Start the Script
		try{
			
			// GET DATASHEET
			//ReadDatasheet ds = new ReadDatasheet();
			//String[][] inputData = ds.readExcelCsv("GoogleSearch.csv");
			
			// Iterate data
			//int length = ds.getTotalRows();
			
			//for(int i = 1; i < length ; i++ ){
				// Step 1 Navigate
				driver.navigate().to("http://toolsqa.com/automation-practice-form/");
				
				WebElement element = Continents(driver);
				
				FindElement.Wait(5);
			//}
			
			//Alert alert = driver.switchTo().alert();
			//alert.accept();
			
			driver.quit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	//Find Continents dropdown box
    public static WebElement Continents(WebDriver driver) {
        WebElement element = null;
                element = driver.findElement(By.id("continents"));
                Select select = new Select(element);
                select.selectByVisibleText("Africa");
                
                
       return element;
    }
}
