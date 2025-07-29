package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MembershipPage;

public class LibraryMembershipSteps {
	WebDriver driver;
	HomePage homePage;
	MembershipPage mp;
	
	public LibraryMembershipSteps(Hooks hooks) {
		this.driver = hooks.getDriver();
		this.homePage = hooks.getHomepage();
		this.mp = new MembershipPage(driver);
	}

	@Given("Go to the Membership section")
	public void go_to_the_membership_section() {
	    // Write code here that turns the phrase above into concrete actions
	    homePage.openMembershipTab();
	}
	
	@Given("drag and drop book")
	public void drag_and_drop_book() {
	    // Write code here that turns the phrase above into concrete actions
	    mp.dragBooktoBox();
	}
	
	@When("Select {string} Membership")
	public void select_membership(String membership) {
	    // Write code here that turns the phrase above into concrete actions
	    if(membership.equals("Gold")) {
	    	mp.selectGoldMembership();
	    }
	    else if(membership.equals("Platinum")) {
	    	mp.selectPlatinumMembership();
	    }
	}
	
	@When("Enter Blank Library card Number")
	public void enter_blank_library_card_number() {
	    // Write code here that turns the phrase above into concrete actions
	    mp.setLibrarycardNumber("");
	}
	
	@When("Click on Submit")
	public void click_on_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    mp.submit();
	}
	
	@Then("The Message {string} should be displayed")
	public void the_message_should_be_displayed(String expected) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(expected,mp.getMessage());
	}

	@When("Enter {string} Library card Number")
	public void enter_library_card_number(String libraryCardNumber) {
	    // Write code here that turns the phrase above into concrete actions
	    mp.setLibrarycardNumber(libraryCardNumber);
	}
	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String expected) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(expected, mp.getErrorMessage());
	}




}
