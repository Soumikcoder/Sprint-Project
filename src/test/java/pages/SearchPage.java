package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {
	
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
		if(name!=null)
			authorName.sendKeys(name);
	}
	
	public void setSubject(String subject)
	{
		if(subject!=null)
			bookSubject.sendKeys(subject);
	}
	
	public void setEdition(String edition)
	{
		if(edition!=null)
		{
			Select select = new Select(bookEdition);
			select.selectByVisibleText(edition);
		}
	}
	
	public void setBookFormat(String format)
	{
		if(format!=null)
		{
			Select select = new Select(bookFormat);
			select.selectByVisibleText(format);
		}
	}
	
	public void setAgeGroup(String age)
	{
        if (age != null) {
            switch (age.toLowerCase()) {
                case "kids":
                    kidsAgeGroup.click(); break;
                case "teen":
                    teenAgeGroup.click(); break;
                case "adult":
                    adultAgeGroup.click(); break;
            }
        }
	}
	
	public void clickSubmitButton()
	{
		submitBtn.click();
	}
	
	public String getResult()
	{
		if(!result.isDisplayed())
			return null;
        return visibilityOfElement(result);
	}
	
	public String getAuthorNameError()
	{
		return visibilityOfElement(authorNameError);
	}
	
	public String getSubjectError()
	{
		return visibilityOfElement(subjectError);
	}
	
	public String getEditionError()
	{
		return visibilityOfElement(editionError);
	}
	
	public String getFormatError()
	{
		return visibilityOfElement(formatError);
	}
	
	public String getAgeGroupError()
	{
		return visibilityOfElement(ageGroupError);
	}
	
	public static String visibilityOfElement(WebElement element)
	{
		try {
			if(element.isDisplayed())
				return element.getText();
		}catch(NoSuchElementException e) {
			return null;
		}
		return null;
	}
}
