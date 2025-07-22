package hooks;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
	
	@After
	public void tearDown() {
		driver.close();
	}
}
