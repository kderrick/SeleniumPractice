package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MozillaFirefoxDriver {

	public static void main(String[] args) {
		final String fireFoxDriver = "webdriver.gecko.driver";
		final String fireFoxDriverPath = "/Users/kylederrick/Desktop/Software/geckodriver";
		final String webSiteURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		final String createAccount = "Create Account";
		
		
		
		//Set web driver
		System.setProperty(fireFoxDriver, fireFoxDriverPath);
		//Instantiate driver
		WebDriver driver = new FirefoxDriver();
		//Open browser and navigate to page
		driver.get(webSiteURL);
		//Locate Elements
		//Click "Create Account" button
		driver.findElement(By.linkText(createAccount)).click();
		//Fill out form
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Jojo Johnson");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("fakemeail@gmail.com");
		//Using Xpath, even though it has an ID
		driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys("503999999");
		//Using CSS Selector, despite having ID
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][type='password']")).sendKeys("password");
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("password");
		
		//Interact with other elements
		//Radio button
		//driver.findElement(By.id("MainContent_Female")).click();
		//Or by using CSS
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();
		
		//Access and select from Dropdown
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("India");
		
		//Check boxes
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail")).click();
		
		//Click Submit button
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
		//Get confirmation after submit
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println(confirmation);
		
		//Close browser
		driver.close();
	}

}
