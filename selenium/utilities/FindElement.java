package hex.selenium.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

// Find an element By
//Id, Css, Xpath, Names 
public class FindElement {

	static WebElement element;
	static Actions action;
	
	public static WebElement FindElement(WebDriver driver, String LocatorType, String LocatorValue){
		
		// Compare the locator type
		switch(LocatorType){
			case "id":
				element = driver.findElement(By.id(LocatorValue));
			break;
			
			case "name":
				element = driver.findElement(By.name(LocatorValue));
				break;
				
			case "xpath":
				element = driver.findElement(By.xpath(LocatorValue));
				break;
			
			case "cssSelector":
				element = driver.findElement(By.cssSelector(LocatorValue));
				break;
				
			case "classname":
				element = driver.findElement(By.className(LocatorValue));
				break;
				
			case "tagname":
				element = driver.findElement(By.tagName(LocatorValue));
				break;
			
			case "linktext":
				element = driver.findElement(By.linkText(LocatorValue));
				break;
				
			case "partialLinkText":
				element = driver.findElement(By.partialLinkText(LocatorValue));
				break;
			
		}
		
		
		return element;
	}
	
	
	public static void Wait(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000); // this receives miliseconds
	}
	
	
	public static WebDriver Navigate(WebDriver driver, String url){
		String page = null;
		try{
			driver.navigate().to(url);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return driver;
	}
	
	public static void Click(WebDriver driver, WebElement element){
		
		try{
			if(element.isDisplayed()){
				element.click();
			}		
				
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
	public static void SendKeys(WebDriver driver, WebElement element, String inputText){
		
		try{
			if(element.isEnabled()){
				element.sendKeys(inputText);
			}		
				
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
