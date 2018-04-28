package tests;

import java.util.List;

import org.junit.After;
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
	String name, email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebElement nameElement, emailElement, phoneElement, passwordElement, passwordVerificationElement, countryElement, femaleRadioElement, maleRadioElement, weeklyEmailCheckBox, monthlyEmailCheckBox, occasionalEmailCheckBox;
	boolean[] checkBoxes = new boolean[]{weeklyEmail, monthlyEmail, occasionalEmail};
	WebDriver driver;
	
	
	//Test Method
	@Test
	public void newAccountTest() {
		System.out.println("New Record : " + name + " " + email + "  "+ phone + " " + gender + " " + password +
				" " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		
		defineWebElements();
		
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
	
	public void defineWebElements() {
		//Define Web Elements
		nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][type='password']"));
		passwordVerificationElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		femaleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
		maleRadioElement = driver.findElement(By.name("ctl00$MainContent$Gender"));
		weeklyEmailCheckBox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		monthlyEmailCheckBox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
		occasionalEmailCheckBox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
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
