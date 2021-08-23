package pageObjects;

import java.util.List;

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

public class ApplyInitialPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyInitialPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#square-selector-label-0")
	private WebElement step1_business;
	
	@FindBy(how = How.CSS, using = "#square-selector-label-1")
	private WebElement step1_realestate;
	
	@FindBy(how = How.CSS, using = "#preferences-selection > div.animated.fadeIn")
	private WebElement loanPreferenceModal;
	
	@FindBy(how = How.CSS, using = "#square-simple-selector-label-1 > div > div.col-11 > div > p")
	private WebElement loanPreferenceText;
	
	@FindBy(how = How.CSS, using = "#square-simple-selector-label-0")
	private WebElement loanPreference1;
	
	@FindBy(how = How.CSS, using = "#square-simple-selector-label-1")
	private WebElement loanPreference2;
	
	@FindBy(how = How.CSS, using = "#square-simple-selector-label-2")
	private WebElement loanPreference3;
	
	@FindBy(how = How.CSS, using = "#first_name")
	private WebElement txtbox_firstname;
	
	@FindBy(how = How.CSS, using = "#last_name")
	private WebElement txtbox_lastname;
	
	@FindBy(how = How.CSS, using = "#email")
	private WebElement txtbox_email;
	
	@FindBy(how = How.CSS, using = "#phone")
	private WebElement txtbox_phoneNo;
	
	@FindBy(how = How.CSS, using = "#legal_business_name")
	private WebElement txtbox_businessName;
	
	@FindBy(how = How.CSS, using = "#referral_source")
	private WebElement dropdown_hearAboutUs;
	
	@FindBy(how = How.CSS, using = "#referral_source")
	private List<WebElement> optList;
	
	@FindBy(how = How.CSS, using = "#privacy_policy")
	private WebElement chkbox_TC;
	
	@FindBy(how = How.CSS, using = "#submit_apply_form")
	private WebElement btn_submit;
	
	@FindBy(how = How.CSS, using = "#cookieConsentModal > div.pf-bar-content > span > button") //#cookieConsentModal > div.pf-bar-content > span > button
	private WebElement btn_acceptCookies;
	
	
	@Test
	public void validateURL(String url) {
		wait.until(ExpectedConditions.visibilityOf(step1_business));
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, url);
	}
	
	public void validateFormFields() {
		Assert.assertEquals(txtbox_firstname.isDisplayed(), true);
		Assert.assertEquals(txtbox_lastname.isDisplayed(), true);
		Assert.assertEquals(txtbox_email.isDisplayed(), true);
		Assert.assertEquals(txtbox_phoneNo.isDisplayed(), true);
		Assert.assertEquals(dropdown_hearAboutUs.isDisplayed(), true);
	}
	
	public void set_step1(String step1Option) {
		if(step1Option.equals("Build my business or refinance an existing debt")) {
			step1_business.click();
		}else if(step1Option.equals("Purchase or refinance commercial real estate")) {
			step1_realestate.click();
		}
		else {
			throw new IllegalArgumentException("No option selected, please select one option");
		}
	}
	
	public void set_loanPreference(String loanPreferenceOption) {
		if(loanPreferenceOption.equals("Help me decide")) {
			jse.executeScript("arguments[0].scrollIntoView()", loanPreference1);
			actions.moveToElement(loanPreference1).click().build().perform();
		}else if(loanPreferenceOption.equals("SBA Loan")) {
			jse.executeScript("arguments[0].scrollIntoView()", loanPreference2);
			actions.moveToElement(loanPreference2).click().build().perform();
		}else if(loanPreferenceOption.equals("Bank Term Loan")) {
			jse.executeScript("arguments[0].scrollIntoView()", loanPreference3);
			actions.moveToElement(loanPreference3).click().build().perform();
		}
		else {
			throw new IllegalArgumentException("No option selected, please select one option");
		}
	}
	
	public void set_FirstName(String firstname) {
		txtbox_firstname.sendKeys(firstname);
	}
	
	public void set_LastName(String lastname) {
		txtbox_lastname.sendKeys(lastname);
	}
	
	public void set_Email(String email) {
		txtbox_email.sendKeys(email);
	}
	
	public void set_PhoneNo(String phone) {
		txtbox_phoneNo.sendKeys(phone);
	}
	
	public void set_BusinessName(String businessName) {
		txtbox_businessName.sendKeys(businessName);
	}
	
	public void set_HearAboutUs(String optName) {
		Select drop = new Select(dropdown_hearAboutUs);
		drop.selectByVisibleText(optName);
		btn_acceptCookies.click();
	}
	
	public void add_PersonalInfo(String firstname, String lastname, String email, String phoneNo, String businessName, String hearAboutUs) {
		set_FirstName(firstname);
		set_LastName(lastname);
		set_Email(email);
		set_PhoneNo(phoneNo);
		set_BusinessName(businessName);
		set_HearAboutUs(hearAboutUs);
	}
	
	public void check_TC(boolean value) {
		if(value) {
			jse.executeScript("arguments[0].scrollIntoView()", chkbox_TC);
			chkbox_TC.click();
		}
	}
	
	public void contToPreQualifyBtn() {
		btn_submit.click();
	}

}
