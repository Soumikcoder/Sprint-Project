package hooks;


import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import pages.HomePage;
//import pages.MembershipPage;
import setup.AppPropProvider;
import setup.DriverSetup;

public class Hooks {
	public WebDriver driver;
		
	@Before
	public void setup() {
		AppPropProvider.initialize();
		driver=DriverSetup.getDriver();
		driver.get(AppPropProvider.get("webUrl"));
	}
	@AfterStep
	public void takeScreenShot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] output=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(output, "image/png", scenario.getName());
		}
	}
	@After
	public void tearDown() {
		driver.close();
	}
}
