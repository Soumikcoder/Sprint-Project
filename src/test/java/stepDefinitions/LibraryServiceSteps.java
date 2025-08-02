
package stepDefinitions;

import java.awt.List;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import junit.framework.Assert;
import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LibraryServicePage;
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
        this.driver = hooks.getDriver();
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
                // Wait for success message
                WebElement successElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("mediummailoutput"))
                );
                actualMessage = successElement.getText().trim();
            } 
            else if (expectedResult.equalsIgnoreCase("Error")) {
                // Check if "Invalid Email" or "Query Required" error appears
                java.util.List<WebElement> errorMessages = driver.findElements(
                    By.cssSelector(".error-message, #queryemailError")
                );

                if (!errorMessages.isEmpty()) {
                    for (WebElement error : errorMessages) {
                        if (error.isDisplayed() && !error.getText().trim().isEmpty()) {
                            actualMessage = error.getText().trim();
                            break;
                        }
                    }
                }
            }

            if (actualMessage.isEmpty()) {
                actualMessage = "No message displayed";
            }

            System.out.println("Expected: " + expectedMessage);
            System.out.println("Actual: " + actualMessage);

            // JUnit Assertion (expected first, actual second)
            Assert.assertEquals("Message mismatch!", expectedMessage, actualMessage);

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

        // JUnit assertions (expected first, actual second)
        Assert.assertEquals("Call message mismatch!", expectedCallMessage, actualCallMessage);
        Assert.assertEquals("Call time mismatch!", expectedTime, actualTime);
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
                actualMessage.equalsIgnoreCase(expectedMessage)
            );

        } catch (Exception e) {
            Assert.fail("Message validation failed: " + e.getMessage());
        }
    }

   
}


    

 