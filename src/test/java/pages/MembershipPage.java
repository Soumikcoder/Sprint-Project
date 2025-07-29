package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MembershipPage extends BasePage{

	public MembershipPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="drag1")
	WebElement book;
	@FindBy(id="div1")
	WebElement dropBox;
	
	@FindBy(id="Gold")
	WebElement goldMembershipOption;
	@FindBy(id="Platinum")
	WebElement platinumMembershipOption;
	
	@FindBy(xpath="//input[contains(@id,'libcardNumber')]")
	List<WebElement> libcardNumberTextBoxes;
	
	@FindBy(id="memberSubmit")
	WebElement submitBtn;
	@FindBy(id="memberoutput")
	WebElement result;
	@FindBy(xpath="//label[contains(@id,'Error')]")
	List<WebElement> errors;
	boolean goldMembership;
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	public void dragBooktoBox() {
//		TODO: Fix drag and drop
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(book));
		wait.until(ExpectedConditions.elementToBeClickable(dropBox));
		Actions act=new Actions(driver);
		act.moveToElement(book).dragAndDrop(book, dropBox).perform();
		
		jse.executeScript("document.querySelector('#membershipform').style.display='block'");
	}
	
	public void selectGoldMembership() {
		goldMembershipOption.click();
		goldMembership=true;
	}
	public void selectPlatinumMembership() {
		jse.executeScript("arguments[0].scrollIntoView()",platinumMembershipOption);
		platinumMembershipOption.click();
		
	}
	public void setLibrarycardNumber(String number) {
		for(WebElement libcardNumberTextBox:libcardNumberTextBoxes) {
			if(libcardNumberTextBox.isDisplayed()) {
				jse.executeScript("arguments[0].scrollIntoView()",libcardNumberTextBox);
				libcardNumberTextBox.sendKeys(number);
			}
		}
		
	}
	public void submit() {
		jse.executeScript("arguments[0].scrollIntoView()",submitBtn);
		submitBtn.click();
	}
	public String getMessage() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", result);
		return result.getText();
	}
	public String getErrorMessage() {
		for(WebElement error:errors) {
			if(error.isDisplayed()) {
				return error.getText();
			}
		}
		return null;
	}
}
