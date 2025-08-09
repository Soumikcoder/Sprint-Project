package stepDefinitions;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.LibraryCardPage;
import utils.DataReader;

public class LibraryCardEntry {

	WebDriver driver;
	HomePage homePage;
	LibraryCardPage lcp;

	List<HashMap<String, String>> datamap;

	public LibraryCardEntry(Hooks hooks) {
		this.driver = hooks.getDriver();
		this.homePage = hooks.getHomepage();
		if (datamap == null) {
			try {
				datamap = DataReader.data(System.getProperty("user.dir") + File.separator + "src" + File.separator
						+ "test" + File.separator + "resources" + File.separator + "LibraryCardData.xlsx", "Sheet1");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Given("Navigate to the url library card entry")
	public void navigate_to_the_url_library_card_entry() {
		homePage.openLibraryCardTab();
		lcp = new LibraryCardPage(driver);

	}

	@Then("Enter the all the data and verify it {string}")
	public void enter_the_all_the_valid_data(String rows) throws InterruptedException {

		int index = Integer.parseInt(rows) - 1;
		String first = datamap.get(index).get("first");
		String last = datamap.get(index).get("last");
		String age = datamap.get(index).get("age");
		String email = datamap.get(index).get("email");
		String phone = datamap.get(index).get("phone");
		String work = datamap.get(index).get("work");
		String orgName = datamap.get(index).get("orgName");

		String cardType = datamap.get(index).get("cardType");
		String exp_res = datamap.get(index).get("res");

		lcp.setFirstName(first);
		lcp.setLastName(last);
		lcp.setAge(age);
		lcp.setEmail(email);
		lcp.setPhone(phone);
		lcp.setWork(work, orgName);

		lcp.setCardType(cardType);

		lcp.clickSubmit();

		try {
			boolean targetpage = lcp.isFormSubmit();
			System.out.println("target page: " + targetpage);
			if (exp_res.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {

					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}

			if (exp_res.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {

				assertTrue(false);
				} else {
					assertTrue(true);
				}
			}

		} catch (Exception e) {

			assertTrue(false);
		}

	}


	@When("The user left the field empty and enters the details and click on submit")
	public void the_user_left_the_field_empty_and_enters_the_details_and_click_on_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    lcp.clickSubmit();
	}

	@Then("verify the details are not submitted")
	public void verify_the_details_are_not_submitted() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(lcp.isFormSubmit(), false);
	}

}
