package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[@id='searchlink']")
	WebElement searchLink;
	@FindBy(xpath="//a[@id='librarycardlink']")
	WebElement libraryCardLink;
	@FindBy(xpath="//a[@id='serviceslink']")
	WebElement servicesLink;
	@FindBy(xpath="//a[@id='bookslink']")
	WebElement booksLink;
	@FindBy(xpath="//a[@id='membershiplink']")
	WebElement membershipLink;
	@FindBy(xpath="//a[@id='memberlink']")
	WebElement memberLink;
	
	public void openSearchTab() {
		searchLink.click();
	}
	public void openLibraryCardTab() {
		libraryCardLink.click();
	}
	public void openServicesTab() {
		servicesLink.click();
	}
	public void openBooksTab() {
		booksLink.click();
	}
	public void openMembershipTab() {
		memberLink.click();
	}
	public void openMembersTab() {
		memberLink.click();
	}
}
