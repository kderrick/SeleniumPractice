package stepImplementations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {
	
	@Given("^user is on the sign in page$")
	public void user_is_on_the_sign_in_page() {
		System.out.println("USer is on Login page");
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		System.out.println("User enters username and password");
	}
	
	@Then("^user gets the confirmation$")
	public void user_gets_the_confirmation() {
		System.out.println("User then gets the confirmation");
	}

}
