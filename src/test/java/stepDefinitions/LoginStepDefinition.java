package stepDefinitions;

import java.util.concurrent.TimeUnit;
//XXXXXXXXXXXXXXXxyyyyyyyyyyyyyyyyyZZZZZzzzzzzz

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageobjects.LoginPage;

public class LoginStepDefinition{
	
	public WebDriver driver;
	public WebDriverWait wait;
	public LoginPage lp;
	
//implementing all the features in the step definition

	@Before
	public void setUp() {
		System.out.println("Starting the test");
	}
	
	@After
	public void tearDown() {
		System.out.println("end of the test");
	}
	
 @Given("The chrome browser to be ready")
	public void the_chrome_browser_to_be_ready() {
	 System.out.println("checking the chrome browser is ready");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		}

 @Given("User launches the chrome browser")
	public void user_launches_the_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    lp=new LoginPage(driver);
	    wait=new WebDriverWait(driver,30);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String string) {
	    driver.get(string);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String user, String password) {
	    lp.setUserName(user);
	    lp.setPassword(password);
	}

	@When("click on login button")
	public void click_on_login_button() {
	    lp.clickLoginBtn();
	}


	@When("User click on logout link")
	public void user_click_on_logout_link() {
	    lp.clickLogoutBtn();
	    
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
		Assert.assertEquals(title,driver.getTitle());
		}
	}
	
    @Then("close the browser")
    public void close_the_browser() {
    	driver.close();
    }



}
