package hooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import setup.DriverSetup;

public class Hooks {
	public WebDriver driver;
	
	@Before
	public void setup() {
		driver=DriverSetup.getDriver();
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
}
