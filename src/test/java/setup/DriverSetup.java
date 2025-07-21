package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	private static WebDriver driver;
	public static WebDriver getDriver() {
		if(driver == null) {
			driver=new FirefoxDriver();
		}
		return driver;
	}
}
