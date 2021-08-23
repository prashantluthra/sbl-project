package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ConfigSteps {
	
	protected WebDriver driver = null;
	
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

}
