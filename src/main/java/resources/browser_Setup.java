package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browser_Setup {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:/Users/sanke/workspace/Siebel_Web/src/main/java/resources/browser_Config.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.out.println("Launching Chrome Browser");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sanke\\workspace\\Siebel_Web\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Website is launched");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Chrome Browser Launched");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.out.println("Launcing Firefoc browser");
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\sanke\\workspace\\Siebel_Web\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Website is launched");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.out.println("Launching IE browser");
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\sanke\\workspace\\Siebel_Web\\drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("IE Browser Launched");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}	


}
