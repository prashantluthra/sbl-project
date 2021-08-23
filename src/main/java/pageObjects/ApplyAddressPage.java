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

public class ApplyAddressPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#street")
	private WebElement txtbox_businessAddress;
	
	@FindBy(how = How.CSS, using = "#apt_45375")
	private WebElement txtbox_suiteApt;
	
	@FindBy(how = How.CSS, using = "#PlacesAutocomplete__autocomplete-container")
	private WebElement box_selectSuggestedAddress;
	
	@FindBy(how = How.CSS, using = "#password_new_prequal")
	private WebElement btn_SaveNCont;
	
	public void type_businessAddress(String businessAddress) {
		txtbox_businessAddress.sendKeys(businessAddress);
	}
	
	public void select_suggestedAddress() {
		jse.executeScript("arguments[0].scrollIntoView()", box_selectSuggestedAddress);
		actions.moveToElement(box_selectSuggestedAddress).click().build().perform();
	}
	
	public void validateAddressBox() {
		wait.until(ExpectedConditions.visibilityOf(txtbox_businessAddress));
		Assert.assertEquals(txtbox_businessAddress.isDisplayed(), true);
	}
	
	public void clickSuiteApt() {
		wait.until(ExpectedConditions.visibilityOf(txtbox_suiteApt));
		txtbox_suiteApt.click();
	}
	
	public void saveAndContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_SaveNCont));
		btn_SaveNCont.click();
	}

}
