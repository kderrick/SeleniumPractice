package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kylederrick/Desktop/Software/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.google.com/");
		driver.findElement(By.id("lst-ib")).sendKeys("Udemy");
		driver.findElement(By.name("btnI")).click();
		String confirm = driver.findElement(By.className("notice-streamer__headline")).getText();
		System.out.println("CONFIRMATION:" + confirm);
	}

}