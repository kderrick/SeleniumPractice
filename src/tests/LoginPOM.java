package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginPOM {
	
	@Test
	public void LoginTestPOM(){
		//1. initialize driver
		WebDriver driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	
		//2. Enter login information
	
		//3. Get confirmation
	
		//4. Close driver
		driver.quit();
	}
	
}
