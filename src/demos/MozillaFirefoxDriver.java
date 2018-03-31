package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaFirefoxDriver {

	public static void main(String[] args) {
		//Set webdriver
		System.setProperty("webdriver.gecko.driver", "/Users/kylederrick/Desktop/Software/geckodriver");
		//Instantiate driver
		WebDriver driver = new FirefoxDriver();
		//Open browser and navigate to page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//Click "Create Account" button
		driver.findElement(By.linkText("Create Account")).click();
		//Fill out form
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Jojo Johnson");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("fakemeail@gmail.com");
	}

}