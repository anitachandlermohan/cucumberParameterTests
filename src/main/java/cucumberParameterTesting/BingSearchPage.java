package cucumberParameterTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingSearchPage {
	@FindBy(id = "sb_form_q")
	private WebElement searchBox;
	WebDriverWait wait;
	
	public void searchFor(String searchterm, WebDriverWait wait) {
		searchBox.sendKeys(searchterm);
		
		searchBox.sendKeys(Keys.ENTER);
	}

}
