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

public class ApplyInceptionDatePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyInceptionDatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_0")
	private WebElement opt_lt2yrs;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_1")
	private WebElement opt_2to5yrs;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_2")
	private WebElement opt_6to10yrs;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_3")
	private WebElement opt_Mt10yrs;
	
	@FindBy(how = How.CSS, using = "#password_new_prequal")
	private WebElement btn_SaveNCont;
	
	public void set_yrsOldPreference(String yrsPreferenceOption) {
		if(yrsPreferenceOption.equals("Less than 2 years ago")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_lt2yrs);
			actions.moveToElement(opt_lt2yrs).click().build().perform();
		}else if(yrsPreferenceOption.equals("2-5 years ago")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_2to5yrs);
			actions.moveToElement(opt_2to5yrs).click().build().perform();
		}else if(yrsPreferenceOption.equals("6-10 years ago")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_6to10yrs);
			actions.moveToElement(opt_6to10yrs).click().build().perform();
		}else if(yrsPreferenceOption.equals("More than 10 years ago")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_Mt10yrs);
			actions.moveToElement(opt_Mt10yrs).click().build().perform();
		}
		else {
			throw new IllegalArgumentException("No option selected, please select one option");
		}
	}
	
	public void validateIncDatePageButtons() {
		wait.until(ExpectedConditions.visibilityOf(opt_lt2yrs));
		Assert.assertEquals(opt_lt2yrs.isDisplayed(), true);
		Assert.assertEquals(opt_2to5yrs.isDisplayed(), true);
		Assert.assertEquals(opt_6to10yrs.isDisplayed(), true);
		Assert.assertEquals(opt_Mt10yrs.isDisplayed(), true);
		Assert.assertEquals(btn_SaveNCont.isDisplayed(), true);
	}
	
	public void validateSaveBtnIsDisabled() {
		Assert.assertEquals(false, btn_SaveNCont.isEnabled());
	}
	
	public void validateSaveBtnIsEnabled() {
		Assert.assertEquals(true, btn_SaveNCont.isEnabled());
	}
	
	public void saveAndContinueBtn() {
		btn_SaveNCont.click();
	}

}
