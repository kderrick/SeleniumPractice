package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestNG {
	
	WebDriver driver;
	
	@Test
	public void loginElementsArePresent() {
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		boolean loginUserID = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean loginPassword = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginUserID, "UserID text box displayed");
		Assert.assertTrue(loginPassword, "Password text box displayed");
		
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Setting up test");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver = utilities.DriverFactory.open("chrome");
		driver.get(webURL);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Tearing down Test");
		driver.close();
	}

}
