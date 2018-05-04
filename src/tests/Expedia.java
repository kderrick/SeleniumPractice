package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String browserType = "Chrome";
	String city = "New York, New York";
	String checkIn = "07/10/2018";
	String checkOut = "07/12/2018";
	
	@Test
	public void hotelReservation() {
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		
		driver.findElement(By.xpath("//*[@id='hotel-checkout-hp-hotel']")).click();
		//driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[4]/div[3]/div/ul/li/div/div/div/div[2]/div[4]/button/span[1]/svg")).click();
		
		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[9]/label/button")).click();
		
		
		driver.findElement(By.cssSelector("input[name='star'][value='40']")).click();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		//Added implicit wait to setUp, cleared fields on search before entering data and modified returned search retults
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
