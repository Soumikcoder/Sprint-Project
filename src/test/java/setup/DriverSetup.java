package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//TODO: Different Browser using prop file
//TODO: 
public class DriverSetup {
	public static WebDriver getDriver() {
		WebDriver driver=null;
		String browser=AppPropProvider.get("browser");
		boolean isHeadless=AppPropProvider.get("headless").equals("true");
			switch(browser) {
				case "firefox":
					FirefoxOptions fo=new FirefoxOptions();
					if(isHeadless)
					fo.addArguments("--headless");
					driver=new FirefoxDriver(fo);
					break;
				case "chrome":
					ChromeOptions co=new ChromeOptions();
					if(isHeadless)
					co.addArguments("--headless=new");
					driver=new ChromeDriver(co);
					break;
				case "edge":
					driver=new EdgeDriver();
					break;
			}
		
		return driver;
	}
}
