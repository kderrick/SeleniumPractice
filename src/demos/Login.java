package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		//Define Webdriver
		System.setProperty("webdriver.chrome.driver", "/Users/kylederrick/Desktop/Software/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//Open Browser and navigate to site
		driver.get("https://www.google.com/");
		
		
		//Locate an element and fill in term
		driver.findElement(By.id("lst-ib")).sendKeys("Udemy");
		//Click feeling lucky box
		driver.findElement(By.name("btnI")).click();
		
		//Grab text from the feeling lucky search results
		String confirm = driver.findElement(By.className("notice-streamer__headline")).getText();
		System.out.println("CONFIRMATION:" + confirm);
		
		//Grab webpage title that appears in the tab
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}

}