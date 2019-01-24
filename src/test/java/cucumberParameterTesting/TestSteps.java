package cucumberParameterTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberParameterTesting.Constants;

public class TestSteps {
	
	ChromeDriver driver;
	ExtentReports extent;
	ExtentTest test;
	WebDriverWait wait;
	String resultString;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_URL);
		extent = TestRunner.extent;
		test = extent.startTest("Bing Test");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		test.log(LogStatus.INFO, "INITIATE BING");
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		driver.manage().window().maximize();
		driver.get(arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1)  {
	  BingSearchPage searchPage = PageFactory.initElements(driver, BingSearchPage.class);
	  resultString = arg1;
	  searchPage.searchFor(arg1, wait);
	     
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {
		assertTrue("not right results page", driver.getTitle().contains(resultString));
	test.log(LogStatus.PASS, "searched for " + resultString + " successfully");
		
	    
	}

}
