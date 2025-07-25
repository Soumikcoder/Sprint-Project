package stepDefinitions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LibraryCardServices {
		WebDriver driver;
		WebDriverWait wait;
		
		
		
@Given("the browser is launched")
public void the_browser_is_launched() {
	//driver.manage().timeouts().implicitlyWait(Duration, 5);
	driver.manage().window().maximize();
}

@And("the Library Support page {string} is loaded")
public void the_library_support_page_is_loaded(String url) {
	driver.get(url);
}

@When("the user selects the Email option")
public void the_user_selects_the_email_option() {
	driver.findElement(By.id(""));
}
@And("enters valid email {string}")
	public void enters_valid_email(String email) {
	driver.findElement(By.xpath(email)).sendKeys(email);
}
@And("enters query {string}")
public void  enters_query(String msg) {
	driver.findElement(By.xpath("")).sendKeys(msg);
}
@And("clicks Submit")
public void click_SubmitBtn() {
	driver.findElement(By.xpath("")).click();
}



}
