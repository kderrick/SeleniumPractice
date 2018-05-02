package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String browserType = "Chrome";
	
	@Test
	public void hotelReservation() {
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.get("https://www.expedia.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
