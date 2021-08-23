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

public class ApplyLoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#email")
	private WebElement txtEmail;
	
	@FindBy(how = How.CSS, using = "#password")
	private WebElement txtPassword;
	
	@FindBy(how = How.CSS, using = "#login_to_flow") 
	private WebElement btn_LogIn;
	
	public void validateLoginPageFields() {
		wait.until(ExpectedConditions.visibilityOf(btn_LogIn));
		Assert.assertEquals(txtEmail.isDisplayed(), true);
		Assert.assertEquals(txtPassword.isDisplayed(), true);
		Assert.assertEquals(btn_LogIn.isDisplayed(), true);
	}
	
	public void set_Email(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void set_Password(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void click_LoginBtn() {
		btn_LogIn.click();
	}

}
