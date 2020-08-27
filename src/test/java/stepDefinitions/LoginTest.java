  package stepDefinitions;


import POM.HomePage;
import POM.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;



public class LoginTest  {
	public WebDriver driver;
	LoginPage lgPage;
	HomePage homepage;
	String url="https://sellercenter.tiki.vn/new/#/user/login";
	//LoginPage lgPage1;
	
	@Before
	public void StartTest() {
		//khoi tao driver
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			this.driver = new FirefoxDriver();
			//System.out.print(driver);
			lgPage = new LoginPage(driver);
			
		//System.out.print(lgPage1.driver);
			
			
		}
	
	@Given("^user open login page$")
    public void user_open_login_page() {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
    }
	@When("^user click on button login$")
    public void user_click_on_button_login() throws InterruptedException {
    	lgPage.submit();
    	Thread.sleep(5000);
    	
    	/**
    	 * how-to-switch-to-popup-window-using
    	 */
    	// Store the CurrentWindow for future reference
    	  
    	  String currentWindow = driver.getWindowHandle();
    	  String popupWindowHandle = null;
    	  
    	  // Switch To Popup Window
    	  
    	  for(String handle : driver.getWindowHandles()){
    	   if(!handle.equals(currentWindow)){
    	    
    	    popupWindowHandle = handle;
    	    
    	   }
    	  }
    	  
    	  driver.switchTo().window(popupWindowHandle);
    
    }

	
	

    @And("^user input correct email$")
    public void user_input_correct_email() throws InterruptedException {
    	WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("thuy.vu@tiki.vn");
		WebElement btnNext = driver.findElement(By.xpath("//div[@id='identifierNext']/div/button/div[2]"));
		btnNext.click();
		Thread.sleep(5000);

    }
   
    @And("^user input correct password$")
    public void user_input_correct_password() throws InterruptedException{
    	WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Tiennam@1234567");
		WebElement btnNext = driver.findElement(By.xpath("//div[@id='passwordNext']/div/button/div[2]"));
		btnNext.click();
		
	
		
		 Thread.sleep(5000);
		
		
    }
    
  

    
    @Then("^Verify user login success$")
    public void verify_user_login_success() throws InterruptedException {
    
    	homepage= new HomePage(driver);
    	
    	Assert.assertEquals(homepage.getTitlePage(), "Trang chủ - Seller Center");
    	
    	
    	
    	
    }


    
    @After
    public void EndTest() {
    	driver.quit();
    }  
}