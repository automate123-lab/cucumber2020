package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	//@CacheLookup marks the element and saves the element,so finds quickly when using it. But in case of StaleElementReferenceException not used
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement Email_editbox;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement password_editbox;
	
	@FindBy(css="input.button-1.login-button")
	@CacheLookup
	WebElement login_btn;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement logout_link;
	
	public void setUserName(String user) {
		Email_editbox.clear();
		Email_editbox.sendKeys(user);
	}
	
	public void setPassword(String password) {
		password_editbox.clear();
		password_editbox.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		login_btn.click();
	}
	
	public void clickLogoutBtn() {
		logout_link.click();
	}
	

}
