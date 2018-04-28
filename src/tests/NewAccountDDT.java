package tests;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name;
	String email;
	String phone;
	String gender;
	String password;
	String country;
	boolean weeklyEmail;
	boolean monthlyEmail;
	boolean occasionalEmail;
	boolean[] checkBoxes = new boolean[]{weeklyEmail, monthlyEmail, occasionalEmail};
	WebDriver driver;
	
	
	//Test Method
	@Test
	public void newAccountTest() {
		System.out.println("New Record : " + name + " " + email + "  "+ phone + " " + gender + " " + password +
				" " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		
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
		WebElement occasionalEmailCheckBox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
		WebElement[] elementArray = new WebElement[]{weeklyEmailCheckBox, monthlyEmailCheckBox, occasionalEmailCheckBox};
		
		//Fill out form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
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
		
		//Check Box Algorithm
		if(weeklyEmail) {
			if(!weeklyEmailCheckBox.isSelected()) {
				weeklyEmailCheckBox.click();
			}
		} else {
			if(weeklyEmailCheckBox.isSelected()) {
				weeklyEmailCheckBox.click();
			}
		}
		
		driver.findElement(By.id("MainContent_btnSubmit")).click();

	}
	
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	//This annotated method passes the data/parameters into the class via constructor below
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("/Users/kylederrick/Desktop/Software/UserAccounts.csv");
	}
	
	//Constructor that passes data to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password,
			String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		
		if(weeklyEmail.equalsIgnoreCase("true")) {
			this.weeklyEmail = true;
		} else {
			this.weeklyEmail = false;
		}
		
		if(monthlyEmail.equalsIgnoreCase("true")) {
			this.monthlyEmail = true;
		} else {
			this.monthlyEmail = false;
		}
		
		if(occasionalEmail.equalsIgnoreCase("true")) {
			this.occasionalEmail = true;
		} else {
			this.occasionalEmail = false;
		}
		
	}

}
