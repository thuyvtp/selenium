package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
 

By btnLogin=By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/button");




public WebDriver driver;



public LoginPage()
{}



/**
 * ham khoi tao co ten trung voi ten cua class
 * @param driver
 */


public LoginPage(WebDriver driver) {
	
	this.driver = driver;
}

/*
public LoginPage(WebDriver mainDriver) {
	// TODO Auto-generated constructor stub
	this.driver=mainDriver;
}
*/




public void submit()
{  
	driver.findElement(btnLogin).click();
	
}




	
}