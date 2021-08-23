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

public class ApplyFinancingNeedsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyFinancingNeedsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-6000")
	private WebElement opt_strictTimeline;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-6001")
	private WebElement opt_flexible;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-6002")
	private WebElement opt_noSpecTime;
	
	@FindBy(how = How.CSS, using = "#financial_needs_new_prequal")
	private WebElement btn_SaveNCont;
	
	public void set_fundingPreference(String fundPreferenceOption) {
		if(fundPreferenceOption.endsWith("2 weeks or less")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_strictTimeline);
			actions.moveToElement(opt_strictTimeline).click().build().perform();
		}else if(fundPreferenceOption.endsWith("about a month works for me")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_flexible);
			actions.moveToElement(opt_flexible).click().build().perform();
		}else if(fundPreferenceOption.endsWith("a specific time in mind")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_noSpecTime);
			actions.moveToElement(opt_noSpecTime).click().build().perform();
		}
		else {
			throw new IllegalArgumentException("No option selected, please select one option");
		}
	}
	
	public void validateFinNeedsButtons() {
		Assert.assertEquals(opt_strictTimeline.isDisplayed(), true);
		Assert.assertEquals(opt_flexible.isDisplayed(), true);
		Assert.assertEquals(opt_noSpecTime.isDisplayed(), true);
		Assert.assertEquals(btn_SaveNCont.isDisplayed(), true);
	}
	
	public void validateSaveBtnIsDisabled() {
		Assert.assertFalse(btn_SaveNCont.isEnabled());
	}
	
	public void validateSaveBtnIsEnabled() {
		Assert.assertTrue(btn_SaveNCont.isEnabled());
	}
	
	public void saveAndContinueBtn() {
		jse.executeScript("arguments[0].scrollIntoView()", btn_SaveNCont);
		btn_SaveNCont.click();
	}


}
