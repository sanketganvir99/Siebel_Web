package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class browser_Setup {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/yml/git/Siebel_Web/src/main/java/resources/browser_Config.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.out.println("Launching Chrome Browser");
			driver = new ChromeDriver();
			System.out.println("Website is launched");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Chrome Browser Launched");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.out.println("Launcing Firefoc browser");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Website is launched");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			System.out.println("Launching Safari browser");
			SafariOptions options = new SafariOptions();
			driver = new SafariDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Safari Browser Launched");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}	


}
