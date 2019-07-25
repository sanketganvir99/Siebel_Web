package cucumber_Options;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
				glue = "step_Definitions", monochrome=true, strict = true,
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:testReports/cucumber_Extent/report.html" }
			)
public class test_Runner {
	
	@AfterClass
	public static void reportSetup() throws IOException {

		Reporter.loadXMLConfig(new File("src/test/java/Siebel_extent-config.xml"));
		Reporter.addScreenCaptureFromPath(
				"D:/Sanket_Ganvir/BDDcucumber_GoJek_Amazon_Project/testReports/cucumber-Extent/failedCase_screenshots.png");
		
	}

}
