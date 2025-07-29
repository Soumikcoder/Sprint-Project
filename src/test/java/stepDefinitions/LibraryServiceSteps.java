/*package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.LibraryServicePage;
import utils.DataReader;

public class LibraryServiceSteps {

    WebDriver driver;
    LibraryServicePage servicePage;
    List<HashMap<String, String>> dataMap;
    HashMap<String, String> testData;

    public LibraryServiceSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.servicePage = new LibraryServicePage(driver);
    }

    @Given("the user navigates to the Library Services form")
    public void navigate_to_form() {
        servicePage.openLibraryServicesPage();  // Define this in your page class
    }

    @When("the user selects {string} option")
    public void select_option(String option) {
        (servicePage).selectOption(option);
    }

    @When("enters email {string}")
    public void enter_email(String email) {
        servicePage.enterEmail(email);
    }

    @When("enters query {string}")
    public void enter_query(String query) {
        servicePage.enterQuery(query);
    }

    @When("clicks Submit")
    public void clicks_submit() {
        servicePage.clickSubmit();
    }

    @Then("verify the result is {string}")
    public void verify_the_result(String expectedResult) {
        boolean isSuccess = (servicePage).isSubmissionSuccessful(expectedResult);
        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue("Expected success but got failure", isSuccess);
        } else {
            Assert.assertFalse("Expected failure but got success", isSuccess);
        }
    }

    @Then("the message should be {string}")
    public void message_should_be(String expectedMessage ,String actualMessage ) {
         actualMessage = servicePage.getResultMessage();
        Assert.assertTrue("Expected message to contain: " + expectedMessage, actualMessage.contains(expectedMessage));
    }

    // Optional: A step to use row_index from Excel (data-driven)
    @Then("fill the Library form with data from row {string}")
    public void fill_library_form_with_excel(String rowIndex) {
        try {
            String excelPath = System.getProperty("user.dir") + File.separator + "src" +
                    File.separator + "test" + File.separator + "resources" + File.separator + "LibraryServiceForm.xlsx";
            dataMap = DataReader.data(excelPath, "EmailTests");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int index = Integer.parseInt(rowIndex) - 1;
        testData = dataMap.get(index);

        servicePage.selectOption(testData.get("option"));
        servicePage.enterEmail(testData.get("email"));
        servicePage.enterQuery(testData.get("query"));
        servicePage.clickSubmit();
    }

    @Then("verify result and message from the same row")
    public void verify_result_and_message_from_excel(String actualMessage) {
        boolean actualResult = (servicePage).isSubmissionSuccessful(null);
        String expectedResult = testData.get("expected_result");
        String expectedMessage = testData.get("message");
        actualMessage = servicePage.getResultMessage();

        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue("Expected success but got failure", actualResult);
        } else {
            Assert.assertFalse("Expected failure but got success", actualResult);
        }

        Assert.assertTrue("Expected message to contain: " + expectedMessage, actualMessage.contains(expectedMessage));
    }
}
*/
package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LibraryServicePage;
import setup.DriverSetup;
import utilities.ExcelReader;
//import utils.DataReader;

public class LibraryServiceSteps {

	WebDriver driver;
    HomePage homePage;
    LibraryServicePage libraryCardServicesPage;
    LibraryServicePage page;
    ExcelReader reader = new ExcelReader();
    String basePath = System.getProperty("user.dir") + "/src/test/resources/testdata/LibraryServiceData.xlsx";
    String actualMessage = "";

    // Constructor to get driver and page objects from Hooks
    public LibraryServiceSteps(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.homePage = hooks.getHomepage();
        this.libraryCardServicesPage = new LibraryServicePage(driver);
        this.page = new LibraryServicePage(driver);
    }

    @Given("the user navigates to the Library Services form")
    public void the_user_navigates_to_the_Library_Services_form() {
        page.openLibraryServicesPage();
    }

    
    	@When("the user selects Email option")
    	public void the_user_selects_email_option() {
    	    page.openAndSelectEmailOption(); // Handles service tab + email radio click
    	}

    

   

    @And("enters email {string}")
    public void enters_email(String rowIndexStr) {
        int rowIndex = Integer.parseInt(rowIndexStr);
        String email = reader.getCellData(basePath, "Sheet1", rowIndex, 2); // Assuming email is column 1
        page.enterEmail(email);
    }

    @And("enters query {string}")
    public void enters_query(String rowIndexStr) {
        int rowIndex = Integer.parseInt(rowIndexStr);
        String query = reader.getCellData(basePath, "Sheet1", rowIndex, 3); // Assuming query is column 2
        page.enterQuery(query);
    }

    @And("clicks Submit")
    public void clicks_Submit() {
        page.clickSubmit();
    }

    @Then("verify the result is {string}")
    public void verify_the_result_is(String expectedStatus) {
        actualMessage = page.getResultMessage();
        if (expectedStatus.equalsIgnoreCase("Success")) {
            Assert.assertTrue(!actualMessage.isEmpty(), "Expected success message but got empty.");
        } else if (expectedStatus.equalsIgnoreCase("Error")) {
            Assert.assertTrue(actualMessage.toLowerCase().contains("error") || actualMessage.isEmpty(), "Expected error message but got: " + actualMessage);
        }
    }

    @And("the message should be {string}")
    public void the_message_should_be(String expectedMessage) {
        Assert.assertEquals(actualMessage, expectedMessage, "Expected message mismatch.");
    }
}
