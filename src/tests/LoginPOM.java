package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.DashboardPage;
import pages.LoginPage;

public class LoginPOM {
	
	@Test
	public void LoginTestPOM(){
		//1. initialize driver
		WebDriver driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	
		//2. Enter login information
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickSubmit();
	
		//3. Get confirmation from Dashboard Page
		DashboardPage dashboardPage = new DashboardPage(driver);
		String confirmation = dashboardPage.confirmationMessage();
		String pageTitle = dashboardPage.getTitle();
		
		//4. Assertions
		Assert.assertTrue(confirmation.contains("success"));
		Assert.assertTrue(pageTitle.contains("Account"));
		
		
		
		//5. Close driver
		driver.quit();
	}
	
}
