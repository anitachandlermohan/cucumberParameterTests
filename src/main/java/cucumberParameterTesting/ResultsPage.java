package cucumberParameterTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	WebDriverWait wait;
	@FindBy(id = "sb_form_q")
	private WebElement searchBar;
	
	public String returnSearchBar() {
		
		return searchBar.getText(); 
	}

}
