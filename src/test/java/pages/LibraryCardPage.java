package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryCardPage extends BasePage{
   
	public LibraryCardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//WebElements
@FindBy(id = "first")
private WebElement firstNameInput;

@FindBy(id = "last")
private WebElement lastNameInput;

@FindBy(id = "age")
private WebElement ageInput;

@FindBy(id = "email")
private WebElement emailInput;

@FindBy(id = "phone")
private WebElement phoneInput;

@FindBy(xpath="//*[@id=\"work_0\"]")
private WebElement Student;

@FindBy(xpath="//*[@id=\"work_1\"]")
 private WebElement Employee;
@FindBy(id="company")
private WebElement company;
@FindBy(id="school")
 private WebElement school;

@FindBy(id = "action")
private WebElement cardTypeDropdown;

@FindBy(id = "libraryCardSubmit")
private WebElement submitBtn;

@FindBy(id = "idcard")  
private WebElement successMessage;


// Action Methods
public void setFirstName(String firstName) {
    firstNameInput.sendKeys(firstName);
}

public void setLastName(String lastName) {
    lastNameInput.sendKeys(lastName);
}

public void setAge(String age) {
    ageInput.sendKeys(age);
}

public void setEmail(String email) {
    emailInput.sendKeys(email);
}

public void setPhone(String phone) {
    phoneInput.sendKeys(phone);
}

public void setWork(String work,String OrgName) throws InterruptedException {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         if(work.equalsIgnoreCase("student")) {
        	 Student.click();
        	
     		wait.until(ExpectedConditions.visibilityOf(school));
        	 school.sendKeys(OrgName);
         }
         else 
         {
        	 Employee.click();
        	 wait.until(ExpectedConditions.visibilityOf(company));
        	 company.sendKeys(OrgName);
         }
}

public void setCardType(String cardType) {
    Select select = new Select(cardTypeDropdown);
      select.selectByVisibleText(cardType);
}

public void clickSubmit() {
    submitBtn.click();
}	
	
	
public boolean isFormSubmit() {
    try {
    	
      
        scrollToElement(successMessage);
        
        return successMessage.isDisplayed(); 
       
    } catch (NoSuchElementException e) {
        return false;
    }
}
public void scrollToElement(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", element);
}
	

}
