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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyIndustryPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyIndustryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#business_type_id")
	private WebElement dropdown_businessType;
	
	@FindBy(how = How.CSS, using = "#password_new_prequal")
	private WebElement btn_SaveNCont;
	
	public void set_BusinessType(String optName) {
		Select drop = new Select(dropdown_businessType);
		drop.selectByVisibleText(optName);
	}
	
	public void validateBIDropDown() {
		wait.until(ExpectedConditions.visibilityOf(dropdown_businessType));
		Assert.assertEquals(dropdown_businessType.isDisplayed(), true);
	}
	
	
	public void saveAndContinueBtn() {
		btn_SaveNCont.click();
	}

}
