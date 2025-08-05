package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
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
	
	//It opens the search functionality
	public void openSearchTab() {
		searchLink.click();
	}
	
	//It open the Library Card Tab
	public void openLibraryCardTab() {
		libraryCardLink.click();
	}
	
	//It open the service Tab
	public void openServicesTab() {
		servicesLink.click();
	}
	
	//It will open the Books Tab
	public void openBooksTab() {
		booksLink.click();
	}
	
	//It will opens the membership Tab
	public void openMembershipTab() {
		membershipLink.click();
	}
	
	//It will open the Members Tab
	public void openMembersTab() {
		memberLink.click();
	}
}
