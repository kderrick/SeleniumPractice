package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	
	@FindBy(id="MainContent_txtUserName")
	WebElement userNameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passwordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement submitButton;
	
	
	//Steps
	public void setUserName(String userName) {
		userNameBox.sendKeys(userName);
	}
	
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	
	//Actions
	
	public void logIn(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickSubmit();
	}
	
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		//Initialize Web Elements
		PageFactory.initElements(driver, this);
	}

}
