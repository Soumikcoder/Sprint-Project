package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;
import setup.DriverSetup;

public class ValidatingSearchBooks {
	
	private static WebDriver driver;	
	HomePage homePage;
	List<Map<String, String>> booksData;
	Map<String, String> bookData;  
	SearchPage searchPageObj;

	public ValidatingSearchBooks(Hooks hooks) {
		driver = Hooks.getDriver();
		this.homePage = hooks.getHomepage();
	}
	
	
	@Given("Navigate to the search page")
	public void navigate_to_the_search_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		homePage.openSearchTab();
		searchPageObj = new SearchPage(driver);
	}

	@When("Enter valid data for all the fields")
	public void enter_valid_data_for_all_the_fields(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		
		booksData = dataTable.asMaps(String.class, String.class);
		
		bookData = booksData.get(0);
		
		searchPageObj.setAuthorName(bookData.get("Author"));
		searchPageObj.setSubject(bookData.get("Subject"));
		searchPageObj.setEdition(bookData.get("Edition"));
		searchPageObj.setBookFormat(bookData.get("Format"));
		searchPageObj.setAgeGroup(bookData.get("Age"));
	}

	@When("Click the Submit button")
	public void click_the_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		searchPageObj.clickSubmitButton();
	}

	@Then("Matching book record appears for the given criteria")
	public void matching_book_record_appears_for_the_given_criteria() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		String result = searchPageObj.getResult();
		Assert.assertNotNull(result);
	}

	@When("Leave some or all of the fields blank")
	public void leave_some_or_all_of_the_fields_blank(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		
		booksData = dataTable.asMaps(String.class, String.class);
		
		bookData = booksData.get(0);
		
		searchPageObj.setAuthorName(bookData.get("Author"));
		searchPageObj.setSubject(bookData.get("Subject"));
		searchPageObj.setEdition(bookData.get("Edition"));
		searchPageObj.setBookFormat(bookData.get("Format"));
		searchPageObj.setAgeGroup(bookData.get("Age"));
	}

	@Then("Blank fields show error message to fill the respective fields")
	public void blank_fields_show_error_message_to_fill_the_respective_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		Assert.assertNotNull(searchPageObj.getAuthorNameError());
		Assert.assertNotNull(searchPageObj.getSubjectError());
		Assert.assertNotNull(searchPageObj.getEditionError());
		Assert.assertNotNull(searchPageObj.getFormatError());
		Assert.assertNotNull(searchPageObj.getAgeGroupError());
	}

	@When("Enter Invalid Author Name and other fields correctly")
	public void enter_invalid_author_name_and_other_fields_correctly(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		
		booksData = dataTable.asMaps(String.class, String.class);
		
		bookData = booksData.get(0);
		
		searchPageObj.setAuthorName(bookData.get("Author"));
		searchPageObj.setSubject(bookData.get("Subject"));
		searchPageObj.setEdition(bookData.get("Edition"));
		searchPageObj.setBookFormat(bookData.get("Format"));
		searchPageObj.setAgeGroup(bookData.get("Age"));
	}

	@Then("Error message or warning should be displayed for invalid author name")
	public void error_message_or_warning_should_be_displayed_for_invalid_author_name() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		String authorNameError = searchPageObj.getAuthorNameError();
		Assert.assertNotNull(authorNameError);
	}

	@When("Enter Invalid subject and other fields correctly")
	public void enter_invalid_subject_and_other_fields_correctly(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		
		booksData = dataTable.asMaps(String.class, String.class);
		
		bookData = booksData.get(0);
		
		searchPageObj.setAuthorName(bookData.get("Author"));
		searchPageObj.setSubject(bookData.get("Subject"));
		searchPageObj.setEdition(bookData.get("Edition"));
		searchPageObj.setBookFormat(bookData.get("Format"));
		searchPageObj.setAgeGroup(bookData.get("Age"));
	}

	@Then("Error message or warning should be displayed for invalid subject")
	public void error_message_or_warning_should_be_displayed_for_invalid_subject() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		String subjectError = searchPageObj.getSubjectError();
		Assert.assertNotNull(subjectError);
	}

	@When("Enter lowercase\\/mixed-case values for author name and subject")
	public void enter_lowercase_mixed_case_values_for_author_name_and_subject(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		
		booksData = dataTable.asMaps(String.class, String.class);
		
		bookData = booksData.get(0);
		
		searchPageObj.setAuthorName(bookData.get("Author"));
		searchPageObj.setSubject(bookData.get("Subject"));
		searchPageObj.setEdition(bookData.get("Edition"));
		searchPageObj.setBookFormat(bookData.get("Format"));
		searchPageObj.setAgeGroup(bookData.get("Age"));
	}

	@Then("Matching book is displayed")
	public void matching_book_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		String result = searchPageObj.getResult();
		Assert.assertNotNull(result);
	}

	@When("Enter valid but mismatched author")
	public void enter_valid_but_mismatched_author(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		
		booksData = dataTable.asMaps(String.class, String.class);
		
		bookData = booksData.get(0);
		
		searchPageObj.setAuthorName(bookData.get("Author"));
		searchPageObj.setSubject(bookData.get("Subject"));
		searchPageObj.setEdition(bookData.get("Edition"));
		searchPageObj.setBookFormat(bookData.get("Format"));
		searchPageObj.setAgeGroup(bookData.get("Age"));
	}

	@Then("No Book Record is displayed")
	public void no_book_record_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		String result = searchPageObj.getResult();
		Assert.assertNull(result);
	}

	@When("Enter valid but mismatched subject")
	public void enter_valid_but_mismatched_subject(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		
		booksData = dataTable.asMaps(String.class, String.class);
		
		bookData = booksData.get(0);
		
		searchPageObj.setAuthorName(bookData.get("Author"));
		searchPageObj.setSubject(bookData.get("Subject"));
		searchPageObj.setEdition(bookData.get("Edition"));
		searchPageObj.setBookFormat(bookData.get("Format"));
		searchPageObj.setAgeGroup(bookData.get("Age"));
	}

}
