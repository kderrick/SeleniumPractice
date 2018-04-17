package smoketests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

	@Test
	public void pageTitleTest() {
		String websiteURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get(websiteURL);
		String testTitle = driver.getTitle();
		String ActualSiteTitle = "SDET Training | Account Management";
	}
}
