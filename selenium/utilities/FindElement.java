package hex.selenium.utilities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	public static void SwitchToWindows(WebDriver driver) {
		String currWin;
		currWin = driver.getWindowHandle();
		System.out.println(currWin);
		Set<String> handles = driver.getWindowHandles();
		String windowChild;
		handles.remove(currWin);
		
		for(String winHandle :handles){

			if(winHandle != currWin){
			 windowChild = winHandle;
			driver.switchTo().window(windowChild);
			System.out.println("Current window : " + windowChild);
			}
		}
	}
	
	
	public static WebElement SwitchToFrame(WebDriver driver, WebElement element) {
		
		if(element != null) {
			driver.switchTo().frame(element);
		}
		
		return element;
	}
	
	public static WebDriver SwitchToDefaultContent(WebDriver driver) {
		try 
		{
			driver.switchTo().defaultContent();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return driver;
	}
	
	
	public static Actions mouseOver(WebDriver driver, WebElement element) {
		try {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return action;
	}
	
	public static Actions mouseOverandClick(WebDriver driver, WebElement element, WebElement elementToClick) {
		
		action = new Actions(driver);
		action.moveToElement(element).click(elementToClick).perform();
		
		return action;
	}
	
	
	public static Actions DragandDrop(WebDriver driver, WebElement element, WebElement otherElement) {
		
		action = new Actions(driver);
		action.clickAndHold(element)
		.release(otherElement)
		.build();
		
		return action;
	}
	
	// More actions can be added
	public static Actions ActionsHanlder(WebDriver driver, WebElement element, String actionName) {
		
		action = new Actions(driver);
		
		switch(actionName) {
		
		case "DoubleClick":
			action.moveToElement(element).doubleClick().perform();
			break;
		}
		
		
		return action;
	}
	
	
	public static void scroll(WebDriver driver,WebElement element, String value) {
		
		try 
		{
			if(element != null) {
				((JavascriptExecutor)driver).executeScript("window.scrollBy(" + value + ");", element);
			}else {
				((JavascriptExecutor)driver).executeScript("window.scrollBy(" + value + ");");
			}
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	
	
	public static void AcceptAlert(WebDriver driver) {
		try 
		{
			driver.switchTo().alert().accept();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void DissmissAlert(WebDriver driver) {
		
		try 
		{
			driver.switchTo().alert().dismiss();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static void AcceptalertifExist(WebDriver driver) {

		try {
			if(isAlertPresent(driver)) {
				driver.switchTo().alert().accept();
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static String GetAlertText(WebDriver driver) {
		String result = "";
		try 
		{
			result = driver.switchTo().alert().getText();
			
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return result;
	}
	
	public static boolean isAlertPresent(WebDriver driver) {
		try 
		{
			driver.switchTo().alert();
			return true;
			
		}catch(Exception ex) {
			return false;
		}
	}
	
	public static boolean isAttributePresent(WebElement element, String attribute) {
		
		Boolean result = false;
		
		try 
		{
			String value = element.getAttribute(attribute);
			if(value != null) {
				return true;
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
}
