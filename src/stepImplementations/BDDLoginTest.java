package stepImplementations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {
	
	WebDriver driver;
	
	@Given("^user is on the sign in page$")
	public void user_is_on_the_sign_in_page() {
		System.out.println("USer is on Login page");
		
		driver = utilities.DriverFactory.open("Chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		System.out.println("User enters username and password");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
	}
	
	@Then("^user gets the confirmation$")
	public void user_gets_the_confirmation() {
		System.out.println("User then gets the confirmation");
		Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
	}

}
