
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryServicePage {
    WebDriver driver;

    // Constructor
    public LibraryServicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // URL navigation
    public void openLibraryServicesPage() {
    
        driver.get("http://webapps.tekstac.com/SeleniumApp2/Library/Library.html");
    }

    
    @FindBy(id = "serviceslink")
    WebElement serviceTab;
    
    @FindBy(xpath = "//input[@id='medium_email']")
    WebElement emailRadio;

    // Email input fields
    @FindBy(xpath = "//input[@id='fromEmail']")
    WebElement emailInput;

    @FindBy(id = "queryemail")
    WebElement queryInput;

    @FindBy(id = "QuerySubmit")
    WebElement submitButton;
    
    /*---------------------call--------------------*/
    @FindBy(xpath = "//input[@id='medium_call']")
    WebElement callRadio;

    // Call message display
    @FindBy(xpath = "//label[normalize-space()='Call our Librarian at 982-098-8900']")
    WebElement callMessage;

    @FindBy(xpath = "//label[normalize-space()='Time : 10am - 3pm']")
    WebElement callTime;
    
    /*---------------------chat--------------------*/
    @FindBy(xpath = "//input[@id='medium_chat']")
    WebElement chatRadio;

    @FindBy(id = "chatname")
    WebElement nameInput;

    @FindBy(id = "yourphone")
    WebElement phoneInput;

    @FindBy(id = "querychat")
    WebElement chatQueryInput;

    @FindBy(id = "QuerySubmit")
    WebElement chatSubmitButton;

   

    @FindBy(id = "yourphoneError")
    WebElement chatPhoneErrorMessage;

    
    public void openAndSelectEmailOption() {
    //	serviceTab.click();
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         // Click Services Tab
         wait.until(ExpectedConditions.elementToBeClickable(serviceTab));
         serviceTab.click();

         

         // Wait until Email radio is clickable
         wait.until(ExpectedConditions.elementToBeClickable(emailRadio));

         // Click Email radio using JavaScript
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailRadio);

         // Wait a bit for email form fields to appear
        
    }


   // Enter email address
    public void enterEmail(String email) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until email input is visible
        wait.until(ExpectedConditions.visibilityOf(emailInput));

        // Scroll email input into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailInput);

        // Interact with email field
        emailInput.clear();
        emailInput.sendKeys(email);
    	   
    }

    // Enter query message
    public void enterQuery(String query) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", queryInput);
        wait.until(ExpectedConditions.elementToBeClickable(queryInput));

        queryInput.clear();
        queryInput.sendKeys(query);
    }

    // Submit the form
    public void clickSubmit() {
        submitButton.click();
    }
    
    
    //----------------------CALL METHODS---------------------
    public void openAndSelectCallOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Services Tab
        wait.until(ExpectedConditions.elementToBeClickable(serviceTab));
        serviceTab.click();

        // Wait for the Call option and click
        wait.until(ExpectedConditions.elementToBeClickable(callRadio));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", callRadio);
    }

    // Method to get call message
    public String getCallMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(callMessage));
        return callMessage.getText().trim();
    }

    // Method to get call time
    public String getCallTime() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(callTime));
        return callTime.getText().trim();
    }
    // ==================== CHAT METHODS =====================
    public void openAndSelectChatOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(serviceTab));
        serviceTab.click();

        

        wait.until(ExpectedConditions.elementToBeClickable(chatRadio));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chatRadio);

        
    }

    public void enterName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameInput);
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterPhone(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterChatQuery(String query1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(chatQueryInput));
        chatQueryInput.clear();
        chatQueryInput.sendKeys(query1);
    }

    public void clickChatSubmit() {
        chatSubmitButton.click();
    }
    private void sleep(long ms) {
        
    }

    // =================== MESSAGE FETCHERS ===================
    public String getChatSuccessMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("mediumchatoutput"))).getText().trim();
    }

    public String getChatErrorMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("phonechatError"))).getText().trim();
    }

    
}
