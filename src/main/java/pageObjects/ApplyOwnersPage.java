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

public class ApplyOwnersPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyOwnersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = ".page-subheader-zilla")
	private WebElement txt_successMsg;
	
	@FindBy(how = How.CSS, using = "#show_details_summary")
	private WebElement link_viewRates;
	
	@FindBy(how = How.CSS, using = "#owners_new_prequal")
	private WebElement btn_SaveNCont;
	
	@FindBy(how = How.CSS, using = "#logout-link") 
	private WebElement btn_LogOut;
	
	@FindBy(how = How.CSS, using = "#app-container > header > section.top-nav.push-text-right > div > div.sb-alert > div > a.btn-primary-blue.add-space-right-margin.cursor-pointer")
	private WebElement btn_signMeOut;
	
	public void validateFirstName(String firstname) {
		wait.until(ExpectedConditions.visibilityOf(btn_SaveNCont));
		String successText = txt_successMsg.getText().toLowerCase();
		String expectedText = firstname.toLowerCase();
		
		boolean fnFound = successText.contains(expectedText);
		
		if(fnFound) {
			System.out.println("First name is displayed in success text message");
		}
		else {
			System.out.println("Users first name is not displayed.");
		}
	}
	
	public void validateOwnersPageButtons() {
		wait.until(ExpectedConditions.visibilityOf(link_viewRates));
		Assert.assertEquals(btn_LogOut.isDisplayed(), true);
	}
	
	public void logOutBtn() {
		btn_LogOut.click();
	}
	
	public void signMeOutBtn() {
		btn_signMeOut.click();
	}

}
