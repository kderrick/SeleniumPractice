package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTestNG {
	
	@Test
	public void loginElementsArePresent() {
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		boolean loginUserID = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean loginPassword = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
	}

}
