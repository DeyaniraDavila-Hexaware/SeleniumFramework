package hex.selenium.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHandler {
	
	// Driver Name
	private String driverName;
	
	// Constructor
	public DriverHandler(String driverName)
	{
		this.driverName = driverName;
	}
	// Get the driver
	public WebDriver getDriverHandler(){
		
		WebDriver driver = null;
		String path;
		
		//Select the driver by driverName
		switch(driverName){
			
		case "Chrome":
			path = "D:\\Training\\Selenium\\Course 2017\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("disable-extensions");
			driver = new ChromeDriver(options);
			break;
		
		case "Firefox":
			path = "D:\\Training\\Selenium\\Course 2017\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
			break;
			
		
		case "Edge":
			path = "D:\\Training\\Selenium\\Course 2017\\Drivers\\MicrosoftWebDriver.exe";
			System.setProperty("webdriver.edge.driver", path);
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("No driver found.");
			break;
			
		}
		return driver;
	}
}
