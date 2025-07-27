package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import setup.DriverSetup;

public class ValidatingSearchBooks {
	
<<<<<<< HEAD
	
	@FindBy(id="authorName")
	private WebElement authorName;
	@FindBy(id="subject")
	private WebElement subject;
	@FindBy(id="edition")
	private WebElement edition;
	@FindBy(id="format")
	private WebElement bookFormat;
	@FindBy(id="formatError")
	private WebElement ageGroup;
	
=======
	private static WebDriver driver;	
>>>>>>> stash
	
	WebDriver driver;
	HomePage homePage;
	   

	public ValidatingSearchBooks(Hooks hooks) {
		this.driver = hooks.getDriver();
		this.homePage = hooks.getHomepage();
	}
	
	@Given("Navigate to the search page")
	public void navigate_to_the_search_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		SearchPage searchPageObj = new SearchPage(driver);
		searchPageObj.openSearchTab();
	}
	
	@When("Enter valid data for all the fields")
	public void enter_valid_data_for_all_the_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Enter valid but mismatched author")
	public void enter_valid_but_mismatched_author() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Enter valid but mismatched subject")
	public void enter_valid_but_mismatched_subject() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("Leave some or all of the fields blank")
	public void leave_some_or_all_of_the_fields_blank() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("Click the Search button")
	public void click_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Then("Matching book record appears for the given criteria")
	public void matching_book_record_appears_for_the_given_criteria() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Then("No Book Record is displayed")
	public void no_book_record_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Then("Nothing is displayed")
	public void nothing_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	@Then("Blank fields show error message to fill the respective fields")
	public void blank_fields_show_error_message_to_fill_the_respective_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
}
