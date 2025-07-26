package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import pages.LibraryCardServicesPage;

public class LibraryCardServicesSteps {

    WebDriver driver = Hooks.getDriver();
    LibraryCardServicesPage libraryCardServicesPage = new LibraryCardServicesPage(driver);

    @When("user selects {string} as medium")
    public void user_selects_as_medium(String medium) {
        libraryCardServicesPage.selectMedium(medium);
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        libraryCardServicesPage.enterEmail(email);
    }

    @When("user enters name {string} and phone {string}")
    public void user_enters_name_and_phone(String name, String phone) {
        libraryCardServicesPage.enterName(name);
        libraryCardServicesPage.enterPhone(phone);
    }

    @When("user enters {string} query {string}")
    public void user_enters_query(String medium, String query) {
        libraryCardServicesPage.enterQuery(medium, query);
    }

    @When("user submits the query")
    public void user_submits_the_query() {
        libraryCardServicesPage.clickSubmit();
    }

    @Then("a success message {string} should be displayed for {string}")
    public void a_success_message_should_be_displayed_for(String expectedMsg, String medium) {
        String actualMsg = libraryCardServicesPage.getSuccessMessageFor(medium);
        Assert.assertEquals(expectedMsg, actualMsg);
    }

    @Then("input fields should be visible")
    public void input_fields_should_be_visible() {
        Assert.assertTrue(libraryCardServicesPage.areInputFieldsVisible());
    }

   /* @Then("an error message {string} should be displayed for {string}")
    public void an_error_message_should_be_displayed_for(String expectedMsg, String medium) {
        String actualError = libraryCardServicesPage.getErrorMessageFor(medium);
        Assert.assertEquals(expectedMsg, actualError);*/
    }
 
