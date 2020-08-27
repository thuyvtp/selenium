package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
	


	WebDriver driver;
	public WebDriver getDriver() {
		return driver;

	}


	public HomePage(WebDriver mainDriver) {
		// TODO Auto-generated constructor stub
		this.driver=mainDriver;
	}



	public  String getTitlePage()
	{
		return driver.getTitle();
	}
}


