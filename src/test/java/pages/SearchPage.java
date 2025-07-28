package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends HomePage {
	
	@FindBy(id="authorName")
	private WebElement authorName;
	@FindBy(id="subject")
	private WebElement bookSubject;
	@FindBy(id="edition")
	private WebElement bookEdition;
	@FindBy(id="format")
	private WebElement bookFormat;
	@FindBy(id="ageGroup_kids")
	private WebElement kidsAgeGroup;
	@FindBy(id="ageGroup_teen")
	private WebElement teenAgeGroup;
	@FindBy(id="ageGroup_adult")
	private WebElement adultAgeGroup;
	
	@FindBy(id="searchSubmit")
	private WebElement submitBtn;
	
	@FindBy(id="books")
	private WebElement result;
	
	@FindBy(id="authorNameError")
	WebElement authorNameError;
	@FindBy(id="subjectError")
	WebElement subjectError;
	@FindBy(id="editionError")
	WebElement editionError;
	@FindBy(id="formatError")
	WebElement formatError;
	@FindBy(id="ageGroupError")
	WebElement ageGroupError;
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void setAuthorName(String name)
	{
		authorName.sendKeys(name);
	}
	
	public void setSubject(String subject)
	{
		bookSubject.sendKeys(subject);
	}
	
	public void setEdition(String edition)
	{
		bookEdition.sendKeys(edition);
	}
	
	public void setBookFormat(String format)
	{
		Select select = new Select(bookFormat);
		select.selectByVisibleText(format);
	}
	
	public void setAgeGroup(String age)
	{
		if(age.equalsIgnoreCase("kids"))
			kidsAgeGroup.click();
		else if(age.equalsIgnoreCase("teen"))
			teenAgeGroup.click();
		else if(age.equalsIgnoreCase("adult"))
			adultAgeGroup.click();
	}
	
	public void clickSubmitButton()
	{
		submitBtn.click();
	}
	
	public String getResult()
	{
		return result.getText();
	}
	
	public String getAuthorNameError()
	{
		if(authorNameError.isDisplayed())
			return authorNameError.getText();
		return null;
	}
	
	public String getSubjectError()
	{
		if(subjectError.isDisplayed())
			return subjectError.getText();
		return null;
	}
	
	public String getEditionError()
	{
		if(editionError.isDisplayed())
			return editionError.getText();
		return null;
	}
	
	public String getFormatError()
	{
		if(formatError.isDisplayed())
			return formatError.getText();
		return null;
	}
	
	public String getAgeGroupError()
	{
		if(ageGroupError.isDisplayed())
			return ageGroupError.getText();
		return null;
	}
}
