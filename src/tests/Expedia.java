package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
		
		
		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[9]/label/button")).click();
		
		//Get name of city seached
		String searchedCity = driver.findElement(By.xpath("//*[@id='hotelResultTitle']/h1")).getText();
		System.out.println("This is the city we searched" + searchedCity);
		
		//Maximize Screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("After maximize wait");
		
		//Click 4 star rating
		driver.findElement(By.cssSelector("input[name='star'][value='40']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("After 4 star wait");
		
		//Click on a dynamic search result
		
		driver.findElement(By.xpath("//*[@id='resultsContainer']/section/article[3]/div[2]/div/a"))
		.sendKeys(Keys.RETURN);
		//Redirect target to newly opened window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		String newWindowHotelName = driver.findElement(By.id("hotel-name")).getText();
		System.out.println(newWindowHotelName);
		
		//One result page, select to book
		driver.findElement(By
				.xpath("//*[@id='rooms-and-rates']/div/article/table/tbody[1]/tr/td[4]/div/div[1]/button"))
				.click();
		
		//Click Pay Now Button
		driver.findElement(By.id("pay-now-button")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Get and print price
		String totalCost = driver.findElement(By.cssSelector("span[class='summary-total amount-value'][data-price-update='total']"))
		.getText();
		System.out.println("Cost is: " + totalCost);
		
		//Get Confirmation
		String pageTitle = driver.getTitle();
		
		Assert.assertTrue(pageTitle.contains("Payment"));
		
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
