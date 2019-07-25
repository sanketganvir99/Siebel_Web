package step_Definitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import resources.browser_Setup;

public class steps extends browser_Setup {

	public static WebDriver driver;

	@Given("^I launch the browser$")
	public void i_launch_the_browser() throws Throwable {
		driver = initializeDriver();
	}

	@Then("^I launch the website$")
	public void i_launch_the_website() throws Throwable {

		driver.get(prop.getProperty("url"));
		System.out.println("Website Launched successfully");
	}

	@Then("^I mousehover on element with identifier \"([^\"]*)\"$")
	public void i_mousehover_on_element_with_identifier_something(String strArg1) throws Throwable {

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id(strArg1))).build().perform();
		System.out.println("Mouse Hovered on id succesfully");

	}

	@Then("^I mousehover on element with xpath \"([^\"]*)\"$")
	public void i_mousehover_on_element_with_xpath_something(String strArg1) throws Throwable {

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(strArg1))).build().perform();
		System.out.println("Mouse Hovered on id succesfully");

	}

	@Then("^I click on element with xpath \"([^\"]*)\"$")
	public void i_click_on_element_with_xpath_something(String strArg1) throws Throwable {

		driver.findElement(By.xpath(strArg1)).click();
		System.out.println("Clicked on element with xpath sucessfully");

	}

	@Then("^I wait for page to load$")
	public void i_wait_for_page_to_load() throws Throwable {

		Thread.sleep(3000);
		System.out.println("Thread sleep wait applied");

	}

	@Then("^I wait implicitly for page to load$")
	public void i_wait_implicitly_for_page_to_load() throws Throwable {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");

	}

	@Then("^I wait explicitly for page to load for xpath \"([^\"]*)\"$")
	public void i_wait_explicitly_for_page_to_load_for_xpath_something(String strArg1) throws Throwable {

		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath(strArg1)));
		System.out.println("Explicit wait for xpath applied");

	}

	@Then("^I enter \"([^\"]*)\" in identifier \"([^\"]*)\"$")
	public void i_enter_something_in_identifier_something(String strArg1, String strArg2) throws Throwable {

		driver.findElement(By.id(strArg2)).clear();
		driver.findElement(By.id(strArg2)).sendKeys(strArg1);
		System.out.println("Text entered in identifier successfully");

	}

	@Then("^I click on element with identifier \"([^\"]*)\"$")
	public void i_click_on_element_with_identifier_something(String strArg1) throws Throwable {

		driver.findElement(By.id(strArg1)).click();

	}

	@Then("^I assert for element with identifier \"([^\"]*)\"$")
	public void i_assert_for_element_with_identifier_something(String strArg1) throws Throwable {

		Boolean b = driver.findElement(By.id(strArg1)).isDisplayed();
		if (b.equals("true")) {
			System.out.println("Asserting of the element with identifier done successfully");
		}
	}

	@Then("^I assert for element with xpath \"([^\"]*)\"$")
	public void i_assert_for_element_with_xpath_something(String strArg1) throws Throwable {

		Boolean b = driver.findElement(By.xpath(strArg1)).isDisplayed();
		if (b.equals("true")) {
			System.out.println("Asserting of the element with identifier done successfully");
		}
	}

	@Then("^I click on element with linktext \"([^\"]*)\"$")
	public void i_click_on_element_with_linktext_something(String strArg1) throws Throwable {

		driver.findElement(By.linkText(strArg1)).click();

	}

	@Then("^I tap enter on identifier \"([^\"]*)\"$")
	public void i_tap_enter_on_identifier_something(String strArg1) throws Throwable {

		WebElement textbox = driver.findElement(By.id(strArg1));
		textbox.sendKeys(Keys.ENTER);

	}

	@Then("^I tap enter on xpath \"([^\"]*)\"$")
	public void i_tap_enter_on_xpath_something(String strArg1) throws Throwable {

		WebElement textbox = driver.findElement(By.xpath(strArg1));
		textbox.sendKeys(Keys.ENTER);

	}

	@Then("^I tap arrowdown on element with id \"([^\"]*)\"$")
	public void i_tap_arrowdown_on_element_with_id_something(String strArg1) throws Throwable {

		driver.findElement(By.id(strArg1)).sendKeys(Keys.ARROW_DOWN);
	}

	@Then("^I scroll the page little down$")
	public void i_scroll_the_page_little_down() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	@Then("^I enter text (.+) in identifier \"([^\"]*)\"$")
	public void i_enter_text_in_identifier_something(String products, String strArg1) throws Throwable {

		driver.findElement(By.id(strArg1)).clear();
		driver.findElement(By.id(strArg1)).sendKeys(products);
		driver.findElement(By.id(strArg1)).sendKeys(Keys.ENTER);
	}

	@Then("^I select \"([^\"]*)\" from the dropdown with identifier \"([^\"]*)\"$")
	public void i_select_something_from_the_dropdown_with_identifier_something(String strArg1, String strArg2)
			throws Throwable {

		Select s = new Select(driver.findElement(By.id(strArg2)));
		s.selectByValue(strArg1);
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println("Capturing screenshot");

			try {
				FileUtils.copyFile(scrFile, new File(
						"D:/Sanket_Ganvir/BDDcucumber_GoJek_Amazon_Project/testReports/cucumber-extent/failedCase_screenshots.png"));
				System.out.println("Screenshot captured on failed case");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@After
	public static void tearDown() {

		driver.close();
		driver.quit();
		driver = null;

	}

}
