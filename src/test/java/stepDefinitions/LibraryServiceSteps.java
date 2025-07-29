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
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    LibraryServicePage libraryServicesPage;
    LibraryServicePage page;
    
    ExcelReader reader = new ExcelReader();
    String basePath = System.getProperty("user.dir") + "/src/test/resources/testdata/LibraryServices.xlsx";
    String actualMessage = "";

    // Constructor to get driver and page objects from Hooks
    public LibraryServiceSteps(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.homePage = hooks.getHomepage();
        this.libraryServicesPage = new LibraryServicePage(driver);
        this.page = new LibraryServicePage(driver);
    }

    @Given("the user navigates to the Library Services form")
    public void the_user_navigates_to_the_Library_Services_form() {
        page.openLibraryServicesPage();
    }

    
    	@When("the user selects {string} option")
    	public void the_user_selects_option(String option) throws InterruptedException {
    	    page.openAndSelectEmailOption();
    	    Thread.sleep(3000); // Wait after clicking services tab
    	    if (option.equalsIgnoreCase("Email")) {
    	        page.openAndSelectEmailOption();
    	    }
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

    @Then("verify the result is {string} and the message should be {string}")
    public void verify_the_result_is_and_the_message_should_be(String expectedResult, String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualMessage = "";

        try {
            if (expectedResult.equalsIgnoreCase("Success")) {
                WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mediummailoutput")));
                actualMessage = successElement.getText().trim();
            } 
            else if (expectedResult.equalsIgnoreCase("Error")) {
                // For errors like "Please enter your query"
                WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queryemailError")));
                actualMessage = errorElement.getText().trim();
            }

            // If no message is found, handle this
            if (actualMessage.isEmpty()) {
                actualMessage = "No message displayed";
            }

            System.out.println("Expected: " + expectedMessage);
            System.out.println("Actual: " + actualMessage);

            Assert.assertEquals(actualMessage, expectedMessage,
                "Expected message: " + expectedMessage + " but found: " + actualMessage);

        } catch (Exception e) {
            Assert.fail("Message validation failed: " + e.getMessage());
        }
    }
    //=========================CALL STEPS===========================
    @Given("the user opens the call option")
    public void the_user_opens_the_call_option() {
        page.openAndSelectCallOption();
    }

    @Then("verify the call message should be {string} and {string}")
    public void verify_the_call_message_should_be_and(String expectedCallMessage, String expectedTime) {
        String actualCallMessage = page.getCallMessage();
        String actualTime = page.getCallTime();

        System.out.println("Expected Call Message: " + expectedCallMessage);
        System.out.println("Actual Call Message: " + actualCallMessage);

        System.out.println("Expected Time: " + expectedTime);
        System.out.println("Actual Time: " + actualTime);

        Assert.assertEquals(actualCallMessage, expectedCallMessage, "Call message mismatch!");
        Assert.assertEquals(actualTime, expectedTime, "Call time mismatch!");
    }


    // ========================= CHAT STEPS =========================
    @Given("the user opens the chat option")
    public void the_user_opens_the_chat_option() {
        page.openAndSelectChatOption();
    }
    @When("the user enters chat name {string}")
    public void the_user_enters_name(String name) {
        page.enterName(name);
    }

    @When("the user enters chat phone {string}")
    public void the_user_enters_phone(String phone) {
        page.enterPhone(phone);
    }

    @When("the user enters chat query {string}")
    public void the_user_enters_chat_query(String query) {
        page.enterChatQuery(query);
    }

    @And("the user clicks on Submit for chat")
    public void the_user_clicks_on_submit() {
        page.clickChatSubmit(); // Calls the chat submit button
    }

    //@Then("a success message should be displayed for chat")
    /*public void a_success_message_should_be_displayed_for_chat() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mediumchatoutput")));
        WebElement chatsuccessMessage = null;
		Assert.assertTrue(chatsuccessMessage.isDisplayed(), "Chat success message not displayed");
    }*/
    @Then("verify the chat result is {string} and the message should be {string}")
    public void verify_the_chat_result_is_and_the_message_should_be(String expectedResult, String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualMessage = "";

        try {
            if (expectedResult.equalsIgnoreCase("Success")) {
                // Success message for chat
                WebElement successElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("mediumchatoutput"))
                );
                actualMessage = successElement.getText().trim();
            } 
            else if (expectedResult.equalsIgnoreCase("Error")) {
                try {
                    // Try to get error element
                    WebElement errorElement = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("phonechatError"))
                    );
                    actualMessage = errorElement.getText().trim();
                } catch (Exception e) {
                    // If error message is not found, fallback to success element
                    WebElement successElement = driver.findElement(By.id("mediumchatoutput"));
                    actualMessage = successElement.getText().trim();
                }
            }

            if (actualMessage.isEmpty()) {
                actualMessage = "No message displayed";
            }

            System.out.println("Expected: " + expectedMessage);
            System.out.println("Actual: " + actualMessage);

            // Compare ignoring case
            Assert.assertTrue(
                actualMessage.equalsIgnoreCase(expectedMessage),
                "Expected message: " + expectedMessage + " but found: " + actualMessage
            );

        } catch (Exception e) {
            Assert.fail("Message validation failed: " + e.getMessage());
        }
    }

   
}


    

 
