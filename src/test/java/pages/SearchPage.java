package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends HomePage {
	
	@FindBy(id="authorName")
	private WebElement authorName;
	@FindBy(id="subject")
	private WebElement subject;
	@FindBy(id="edition")
	private WebElement edition;
	@FindBy(id="format")
	private WebElement bookFormat;
	@FindBy(id="formatError")
	private WebElement ageGroup;
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void openSearchTab() {
		super.openSearchTab();
	}

}
