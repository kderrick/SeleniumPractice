package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	final static String fireFoxDriver = "webdriver.gecko.driver";
	final static String fireFoxDriverPath = "/Users/kylederrick/Desktop/Software/geckodriver";
	
	public static WebDriver open(String browserType) {
		if(browserType.equals("firefox")) {
			//Set web driver
			System.setProperty(fireFoxDriver, fireFoxDriverPath);
			//Instantiate driver
			return new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "/Users/kylederrick/Desktop/Software/chromedriver");
			 return new ChromeDriver();
		}
	}
}
