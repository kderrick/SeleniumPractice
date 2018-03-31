package demos;

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
	}

}
