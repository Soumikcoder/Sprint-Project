package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MembershipPage;

public class LibraryCardEntry {
	
	   WebDriver driver;
	   HomePage homePage;
	   

	public LibraryCardEntry(Hooks hooks) {
		this.driver = hooks.getDriver();
		this.homePage = hooks.getHomepage();
	}

@Given("Navigate to the url library card entry")
public void navigate_to_the_url_library_card_entry() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	  
}

@When("Enter the all the valid data")
public void enter_the_all_the_valid_data() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	
	
}

@When("Click on Submit button to submit the details")
public void click_on_submit_button_to_submit_the_details() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}

@Then("Verify that the details are submitted succcesfully")
public void verify_that_the_details_are_submitted_succcesfully() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}

	
	

}
