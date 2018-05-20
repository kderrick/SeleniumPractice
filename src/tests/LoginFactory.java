package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPageFactory;

public class LoginFactory {
	
	String userName = "tim@testemail.com";
	String password = "trpass";
	
	@Test
	public void LoginTestPageFactory(){
		
		//1. initialize driver
		WebDriver driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//2. Enter Login
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.logIn(userName, password);
	
	}
}
