package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#apply_loading")
	private WebElement btn_letsGetStarted;
	
	@FindBy(how = How.CSS, using = "#financial_needs_new_prequal")
	private WebElement btn_SaveNCont;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_0")
	private WebElement opt_lt2yrs;
	
	@FindBy(how = How.CSS, using = "#business_type_id")
	private WebElement dropdown_businessType;
	
	@FindBy(how = How.CSS, using = "#street")
	private WebElement txtbox_businessAddress;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_0")
	private WebElement opt_noEmployees;
	
	@FindBy(how = How.CSS, using = "#password")
	private WebElement txtbox_password;
	
	@FindBy(how = How.CSS, using = "#owners_new_prequal")
	private WebElement btn_ownerSaveNCont;
	
	@FindBy(how = How.CSS, using = "#login_to_flow") 
	private WebElement btn_LogIn;
	
	@Test
	public void validateURL(String url) {
		
		WebElement waitForElement = null;
		
		switch (url) {
		case "https://qa-app02.smartbizloans.com/apply/loan":
			waitForElement = btn_letsGetStarted;
			break;
		case "https://qa-app02.smartbizloans.com/apply/prequalify/financing_needs":
			waitForElement = btn_SaveNCont;
			break;
		case "https://qa-app02.smartbizloans.com/apply/prequalify/business/inception_date":
			waitForElement = opt_lt2yrs;
			break;
		case "https://qa-app02.smartbizloans.com/apply/prequalify/business/industry":
			waitForElement = dropdown_businessType;
			break;
		case "https://qa-app02.smartbizloans.com/apply/prequalify/business/address":
			waitForElement = txtbox_businessAddress;
			break;
		case "https://qa-app02.smartbizloans.com/apply/prequalify/business/employees":
			waitForElement = opt_noEmployees;
			break;
		case "https://qa-app02.smartbizloans.com/apply/prequalify/business/password":
			waitForElement = txtbox_password;
			break;
		case "https://qa-app02.smartbizloans.com/apply/prequalify/owners":
			waitForElement = btn_ownerSaveNCont;
			break;
		case "https://qa-app02.smartbizloans.com/login":
			waitForElement = btn_LogIn;
			break;

		default:
			System.out.println("Illegal Argument.");
			break;
		}
		
		wait.until(ExpectedConditions.visibilityOf(waitForElement));
		String actualURL = driver.getCurrentUrl();
		System.out.println("actualURL:" + actualURL);
		System.out.println("expectedURL:" + url);
		Assert.assertEquals(actualURL, url);
		if(actualURL.equals(url)) {
			System.out.println("Correct URL");
		}
	}

}
