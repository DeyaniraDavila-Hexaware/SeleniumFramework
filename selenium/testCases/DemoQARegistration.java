package hex.selenium.testCases;

import org.openqa.selenium.WebDriver;

import hex.selenium.stepsObjects.DemoQASteps;
import hex.selenium.utilities.DriverHandler;
import hex.selenium.utilities.FindElement;
import hex.selenium.utilities.ReadDatasheet;

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
			
			// GET DATASHEET
			ReadDatasheet ds = new ReadDatasheet();
			String[][] inputData = ds.readExcelCsv("DemoQA.csv");
			
			// Step 1 Navigate
			FindElement.Navigate(driver, "http://demoqa.com/");
			
			
			// Step 3 Type first name
			// Instead of deyanira 
			// Iterate data
			int length = ds.getTotalRows();
			
			for(int i = 1; i < length ; i++ ){
				// Step 2 Click on Registration
				DemoQASteps.HomePage.RegistrationButton(driver).click();
				
				DemoQASteps.RegistrationPage.FirstNameText(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_NAME"));
				FindElement.Wait(1);
				
				// Step 4 Type last name
				DemoQASteps.RegistrationPage.LastNameText(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_LASTNAME"));
				FindElement.Wait(1);
				
				DemoQASteps.RegistrationPage.CheckHobbyDance(driver).click();
				
				DemoQASteps.RegistrationPage.PhoneNumberTextBox(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_PHONE"));
				FindElement.Wait(1);
				
				DemoQASteps.RegistrationPage.UsernameTextBox(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_USERNAME"));
				FindElement.Wait(1);
				
				DemoQASteps.RegistrationPage.EmailTextBox(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_EMAIL"));
				FindElement.Wait(1);
				
				DemoQASteps.RegistrationPage.PasswordTextBox(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_PASSWORD"));
				FindElement.Wait(1);
				
				DemoQASteps.RegistrationPage.ConfirmPasswordTextBox(driver).sendKeys(ds.GetLocalDataSheetValue(inputData, i ,"DT_PASSWORD_CONFIRM"));
				
				if(DemoQASteps.RegistrationPage.VerifyPasswordLabelSuccessfull(driver)){
					// Step 5 Click in submit button
					// DemoQASteps.RegistrationPage.SubmitButton(driver).click();
					System.out.println("Passed");
					
					FindElement.Wait(5);
				}
				else
					System.out.println("Failed due password.");
				
			}
			
			
			driver.quit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
