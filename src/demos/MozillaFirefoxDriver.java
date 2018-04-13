package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MozillaFirefoxDriver {


	public static void main(String[] args) {
		
		final String webSiteURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		final String createAccount = "Create Account";
		final String name = "Jojo Johnson";
		final String email = "fakemeail@gmail.com";
		final String phoneNumber = "5039999999";
		final String password = "FakePassword";
		final String country = "India";
		String browserType = "firefox";
		WebDriver driver;
		
		//For Check boxes and radio button
		String gender = "male";
		boolean weeklyEmail = true;
		boolean monthlyEmail = true;
		boolean occassionalEmail = false;
		
		//Create WebDriver
		driver = utilities.DriverFactory.open(browserType);
		
		//Open browser and navigate to page
		driver.get(webSiteURL);
		//Locate Elements
		//Click "Create Account" button
		driver.findElement(By.linkText(createAccount)).click();
		
		//Define Web Elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][type='password']"));
		WebElement passwordVerificationElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement femaleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
		WebElement maleRadioElement = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement weeklyEmailCheckBox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		WebElement monthlyEmailCheckBox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
		//Fill out form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		passwordElement.sendKeys(password);
		passwordVerificationElement.sendKeys(password);
		
		//Interact with other elements
		//Radio button

		if(gender.equalsIgnoreCase("Female")){
			femaleRadioElement.click();
		} else {
		maleRadioElement.click();
		}
		
		//Access and select from Dropdown
		new Select(countryElement).selectByVisibleText(country);
		
		//Check boxes
		
		//If set true
		if(weeklyEmail) {
			//Verify if box is already checked
			if(!weeklyEmailCheckBox.isSelected()) {
				//if not, check it
				weeklyEmailCheckBox.click();
			}
			//otherwise
		} else {
			//check if it is checked
			if(weeklyEmailCheckBox.isSelected()) {
				//uncheck it
				weeklyEmailCheckBox.click();
			}
		}
		monthlyEmailCheckBox.click();
		
		//Click Submit button
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
		//Get confirmation after submit
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println(confirmation);
		
		//Close browser
		//driver.close();
	}

}
