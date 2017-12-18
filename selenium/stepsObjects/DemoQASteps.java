package hex.selenium.stepsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQASteps {
	
	// Initial page --> create a class for this\
	// More objects
	public static class HomePage{
		
		// Get Registration button
		public static WebElement RegistrationButton(WebDriver driver){
			WebElement element = null;
					element = driver.findElement(By.id("menu-item-374"));
					
					return element;
		}
	}

	
	// 
	public static class RegistrationPage{
		
		// Find the FirstName text box
		public static WebElement FirstNameText(WebDriver driver){
			WebElement element = null;
					element = driver.findElement(By.name("first_name"));
			
			return element;
		}
		
		// Find the FirstName text box
		public static WebElement LastNameText(WebDriver driver){
			WebElement element = null;
					element = driver.findElement(By.xpath("//*[@id='name_3_lastname']"));
			
			return element;
		}
		
		// Find the FirstName text box
		public static WebElement SubmitButton(WebDriver driver){
			WebElement element = null;
					element = driver.findElement(By.xpath("//*[@name='pie_submit']"));
			
			return element;
		}
		
		public static WebElement CheckHobbyDance(WebDriver driver){
			WebElement element = null;
			element = driver.findElement(By.xpath("//*[@name='checkbox_5[]' and @value='dance']"));
	
			return element;
			
		}
		
		public static WebElement PhoneNumberTextBox(WebDriver driver){
			WebElement element = null;
			element = driver.findElement(By.id("phone_9"));
	
			return element;
			
		}
		
		public static WebElement UsernameTextBox(WebDriver driver){
			WebElement element = null;
			element = driver.findElement(By.id("username"));
	
			return element;
			
		}
		
		public static WebElement EmailTextBox(WebDriver driver){
			WebElement element = null;
			element = driver.findElement(By.name("e_mail"));
	
			return element;
			
		}
		
		public static WebElement PasswordTextBox(WebDriver driver){
			WebElement element = null;
			element = driver.findElement(By.name("password"));
	
			return element;
			
		}
		
		public static WebElement ConfirmPasswordTextBox(WebDriver driver){
			WebElement element = null;
			element = driver.findElement(By.id("confirm_password_password_2"));
	
			return element;
			
		}
		
		public static boolean VerifyPasswordLabelSuccessfull(WebDriver driver){
			WebElement element = null;
			element = driver.findElement(By.id("piereg_passwordStrength"));
	
			boolean returnSuccessPassword = ((element.getText().toString().equalsIgnoreCase("Very weak")) || 
											(element.getText().toString().equalsIgnoreCase("Weak"))
											|| (element.getText().toString().equalsIgnoreCase("Strong")));
			
			return returnSuccessPassword;
			
		}
	}
}
