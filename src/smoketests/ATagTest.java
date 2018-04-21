package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagTest {
	WebDriver driver;
	boolean createAccountPresent = false;
	
	@Test
	public void aTagsTest() {
		//Test the presence of a tag elements on a site
		List <WebElement> aTagElements = driver.findElements(By.tagName("a"));
		int numberOfATags = aTagElements.size();
		System.out.println("There are " + numberOfATags + " a tags on the page");
		for(WebElement element : aTagElements) {
			System.out.println(element.getText()); 
			if(element.getText().equalsIgnoreCase("CREATE ACCOUNT")){
				createAccountPresent = true;
				break;
			};
		}
		
		//Assertion
		Assert.assertTrue(createAccountPresent);
		
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
