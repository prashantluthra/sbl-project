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

public class ApplyPasswordPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#password")
	private WebElement txtbox_password;
	
	@FindBy(how = How.CSS, using = "#password_new_prequal")
	private WebElement btn_SaveNCont;
	
	public void set_password(String password) {
		txtbox_password.sendKeys(password);
	}
	
	public void validatePwdPageButtons() {
		wait.until(ExpectedConditions.visibilityOf(txtbox_password));
		Assert.assertEquals(txtbox_password.isDisplayed(), true);
		Assert.assertEquals(btn_SaveNCont.isDisplayed(), true);
	}
	
	public void saveAndContinueBtn() {
		btn_SaveNCont.click();
	}

}
