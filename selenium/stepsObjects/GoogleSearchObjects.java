package hex.selenium.stepsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchObjects {
	
	// Initial page --> create a class for this\
	// More objects
	public static class HomePage{
		
		// Get Registration button
		public static WebElement SearchTextBox(WebDriver driver){
			WebElement element = null;
					element = driver.findElement(By.id("lst-ib"));
					
					return element;
		}
		
		// Find the FirstName text box
				public static WebElement SearchButton(WebDriver driver){
					WebElement element = null;
							element = driver.findElement(By.name("btnK"));
					
					return element;
				}
	}
	
	
}
