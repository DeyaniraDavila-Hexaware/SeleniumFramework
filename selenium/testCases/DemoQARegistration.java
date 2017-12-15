package hex.selenium.testCases;

import org.openqa.selenium.WebDriver;

import hex.selenium.stepsObjects.DemoQASteps;
import hex.selenium.utilities.DriverHandler;
import hex.selenium.utilities.FindElement;

public class DemoQARegistration {

	// Create a constructor in order to select the driver
	// driverName = Chrome or Edge or Firefox
	public DemoQARegistration(String driverName){
		// 1. Tell which Driver to use
		DriverHandler driverHandler = new DriverHandler(driverName);
		
		// Releasing the driver
		// Start the browser
		WebDriver driver = driverHandler.getDriverHandler();
		
		// Start the Script
		try{
			// Step 1 Navigate
			FindElement.Navigate(driver, "http://demoqa.com/");
			
			// Step 2 Click on Registration
			DemoQASteps.HomePage.RegistrationButton(driver).click();
			
			// Step 3 Type first name
			DemoQASteps.RegistrationPage.FirstNameText(driver).sendKeys("Deyanira");
			
			// Step 4 Type last name
			DemoQASteps.RegistrationPage.LastNameText(driver).sendKeys("Davila");
			
			// Step 5 Click in submit button
			DemoQASteps.RegistrationPage.SubmitButton(driver).click();
			
			FindElement.Wait(30);
			
			driver.quit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
