package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pageObjects.BasePage;

public class BaseSteps {
	private ConfigSteps configSteps;
	private WebDriver driver;
	BasePage basePage;
	
	String baseURL = "https://qa-app02.smartbizloans.com";
	
	public BaseSteps(ConfigSteps configSteps) {
		this.driver = configSteps.driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("I will be directed to {string} page")
	public void i_will_be_directed_to_page(String url) {
		basePage = new BasePage(driver);
		basePage.validateURL(baseURL+url);
	}

}
