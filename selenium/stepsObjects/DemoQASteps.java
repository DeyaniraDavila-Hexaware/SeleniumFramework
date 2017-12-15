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
	}
}
