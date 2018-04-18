package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	WebDriver driver;
	String websiteURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

	@Test
	public void pageTitleTest() {
		System.out.println("Starting the test");
		driver.get(websiteURL);
		String testTitle = driver.getTitle();
		String ActualSiteTitle = "SDET Training | Account Management";
		Assert.assertEquals(testTitle,ActualSiteTitle);
	}
	
	@Before
	public void setUp() {
		System.out.println("Initialize the Driver");
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void tearDown() {
		System.out.println("Closing the driver");
		driver.close();
	}
}
