package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryCardServicesPage {
    WebDriver driver;

    @FindBy(id = "medium_email")
    WebElement emailRadio;

    @FindBy(id = "medium_call")
    WebElement callRadio;

    @FindBy(id = "medium_chat")
    WebElement chatRadio;

    @FindBy(id = "fromEmail")
    WebElement fromInput;

    @FindBy(id = "toEmail")
    WebElement toInput;

    @FindBy(id = "queryemail")
    WebElement queryInput;

    @FindBy(id = "chatname")
    WebElement nameInput;

    @FindBy(id = "yourphone")
    WebElement phoneInput;

    @FindBy(id = "emailQuery")
    WebElement emailQueryInput;

    @FindBy(id = "chatQuery")
    WebElement chatQueryInput;


    @FindBy(id = "querySubmit")
    WebElement querySubmitButton;

    @FindBy(id = "mediummailoutput")
    WebElement successMsg;

   // @FindBy(id = "errorMessage")
   // WebElement errorMsg;


    @FindBy(id = "mediumchatoutput")
    WebElement chatSuccessMsg;
/*
    @FindBy(id = "emailErrorMessage")
    WebElement emailErrorMsg;

    @FindBy(id = "chatErrorMessage")
    WebElement chatErrorMsg;

    @FindBy(id = "emailLogBox")
    WebElement emailLogBox;

    @FindBy(id = "callInfoBox")
    WebElement callInfoBox;

    @FindBy(id = "chatLogBox")
    WebElement chatLogBox;*/

    public LibraryCardServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectMedium(String medium) {
        switch (medium.toLowerCase()) {
            case "email":
                emailRadio.click();
                break;
            case "call":
                callRadio.click();
                break;
            case "chat":
                chatRadio.click();
                break;
        }
    }

    public void enterEmail(String email) {
        fromInput.clear();
        fromInput.sendKeys(email);
    }

    public void enterQuery(String medium, String query) {
        switch (medium.toLowerCase()) {
            case "email":
                emailQueryInput.clear();
                emailQueryInput.sendKeys(query);
                break;
            case "chat":
                chatQueryInput.clear();
                chatQueryInput.sendKeys(query);
                break;
        }
    }

    public void clickSubmit() {
        querySubmitButton.click();
    }

    public String getSuccessMessageFor(String medium) {
        switch (medium.toLowerCase()) {
            case "email":
                return successMsg.getText();
            case "chat":
                return chatSuccessMsg.getText();
            default:
                return "";
        }
    }

   /* public String getErrorMessageFor(String medium) {
        switch (medium.toLowerCase()) {
            case "email":
                return emailErrorMsg.getText();
            case "chat":
                return chatErrorMsg.getText();
            default:
                return "";
        }
    }

    public String getLogOrInfoBoxText(String medium) {
        switch (medium.toLowerCase()) {
            case "email":
                return emailLogBox.getText();
            case "call":
                return callInfoBox.getText();
            case "chat":
                return chatLogBox.getText();
            default:
                return "";
        }
    }*/

   /* public boolean isSubmissionLogged(String medium) {
        return !getLogOrInfoBoxText(medium).isEmpty();
    }*/

    public boolean areInputFieldsVisible() {
        return fromInput.isDisplayed() || nameInput.isDisplayed();
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }
} 
