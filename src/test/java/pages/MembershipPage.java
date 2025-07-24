package pages;

import java.time.Duration;

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
	@FindBy(id="libcardNumberPtm")
	WebElement libcardNumberTextBoxPtm;
	@FindBy(id="libcardNumberGold")
	WebElement libcardNumberTextBoxGold;
	@FindBy(id="memberSubmit")
	WebElement submitBtn;
	@FindBy(id="memberoutput")
	WebElement result;
	
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
		WebElement libcardNumberTextBox=(goldMembership?libcardNumberTextBoxGold:libcardNumberTextBoxPtm);
		jse.executeScript("arguments[0].scrollIntoView()",libcardNumberTextBox);
		libcardNumberTextBox.sendKeys(number);
	}
	public void submit() {
		jse.executeScript("arguments[0].scrollIntoView()",submitBtn);
		submitBtn.click();
	}
	public String getMessage() {
		return result.getText();
	}
}
