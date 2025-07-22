package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//TODO: Different Browser using prop file
//TODO: 
public class DriverSetup {
	private static WebDriver driver;
	public static WebDriver getDriver() {
		if(driver == null) {
			String browser=AppPropProvider.get("browser");
			switch(browser) {
				case "firefox":
					driver=new FirefoxDriver();
					break;
				case "chrome":
					driver=new ChromeDriver();
					break;
				case "edge":
					driver=new EdgeDriver();
					break;
			}
		}
		return driver;
	}
}
