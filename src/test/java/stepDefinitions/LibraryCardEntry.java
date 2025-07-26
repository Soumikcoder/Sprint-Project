package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.*;
import pages.HomePage;
import pages.LibraryCardPage;
import pages.MembershipPage;
import utils.DataReader;

import java.io.IOException;
import java.util.*;

public class LibraryCardEntry {
	
	   WebDriver driver;
	   HomePage homePage;
	   LibraryCardPage lcp;
	   
  List<HashMap<String,String>>datamap;
	
  public LibraryCardEntry(Hooks hooks) {
		this.driver = hooks.getDriver();
		this.homePage = hooks.getHomepage();
		
	}

@Given("Navigate to the url library card entry")
public void navigate_to_the_url_library_card_entry() {
          homePage.openLibraryCardTab();
          lcp = new LibraryCardPage(driver); 
	  
}

@Then("Enter the all the valid data and verify it {string}")
public void enter_the_all_the_valid_data(String rows) throws InterruptedException {
	try {
		datamap=DataReader.data("C:\\Users\\91920\\git\\Sprint-Project\\src\\test\\resources\\LibraryCardData.xlsx", "Sheet1");
	} 
    catch (IOException e) 
    {
		e.printStackTrace();
	}

    int index=Integer.parseInt(rows)-1;
    String first= datamap.get(index).get("first");
    String last= datamap.get(index).get("last");
    String age= datamap.get(index).get("age");
    String email= datamap.get(index).get("email");
    String phone= datamap.get(index).get("phone");
    String work= datamap.get(index).get("work");
    String orgName=datamap.get(index).get("orgName");
    
    String cardType= datamap.get(index).get("cardType");
    String exp_res= datamap.get(index).get("res");
    

   
    lcp.setFirstName(first);
    lcp.setLastName(last);
    lcp.setAge(age);
    lcp.setEmail(email);
    lcp.setPhone(phone);
    lcp.setWork(work,orgName);
   
    lcp.setCardType(cardType);

    lcp.clickSubmit();
   
    try
    {
        boolean targetpage=lcp.isFormSubmit();
        System.out.println("target page: "+ targetpage);
        if(exp_res.equalsIgnoreCase("Valid"))
        {
            if(targetpage==true)
            {
                
               
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }

        if(exp_res.equalsIgnoreCase("Invalid"))
        {
            if(targetpage==true)
            {
                
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }


    }
    catch(Exception e)
    {

        Assert.assertTrue(false);
    }

    
}


	
	

}
