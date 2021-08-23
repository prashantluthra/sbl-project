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

public class ApplyEmployeesPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jse;
	
	public ApplyEmployeesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		jse = (JavascriptExecutor)driver;
	}
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_0")
	private WebElement opt_noEmployees;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_1")
	private WebElement opt_1to5emp;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_2")
	private WebElement opt_6to10emp;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_3")
	private WebElement opt_11to20emp;
	
	@FindBy(how = How.CSS, using = "#bordered-selector-label-option_4")
	private WebElement opt_Mt20emp;
	
	@FindBy(how = How.CSS, using = "#password_new_prequal")
	private WebElement btn_SaveNCont;
	
	public void set_noOfEmpPreference(String noOfEmpOption) {
		if(noOfEmpOption.equals("No Employees - just me")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_noEmployees);
			actions.moveToElement(opt_noEmployees).click().build().perform();
		}else if(noOfEmpOption.equals("1-5 employees")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_1to5emp);
			actions.moveToElement(opt_1to5emp).click().build().perform();
		}else if(noOfEmpOption.equals("6-10 employees")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_6to10emp);
			actions.moveToElement(opt_6to10emp).click().build().perform();
		}else if(noOfEmpOption.equals("11-20 employees")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_11to20emp);
			actions.moveToElement(opt_11to20emp).click().build().perform();
		}else if(noOfEmpOption.equals("More than 20 employees")) {
			jse.executeScript("arguments[0].scrollIntoView()", opt_Mt20emp);
			actions.moveToElement(opt_Mt20emp).click().build().perform();
		}
		else {
			throw new IllegalArgumentException("No option selected, please select one option");
		}
	}
	
	public void validateEmpPageButtons() {
		wait.until(ExpectedConditions.visibilityOf(opt_noEmployees));
		Assert.assertEquals(opt_noEmployees.isDisplayed(), true);
		Assert.assertEquals(opt_1to5emp.isDisplayed(), true);
		Assert.assertEquals(opt_6to10emp.isDisplayed(), true);
		Assert.assertEquals(opt_11to20emp.isDisplayed(), true);
		Assert.assertEquals(opt_Mt20emp.isDisplayed(), true);
		Assert.assertEquals(btn_SaveNCont.isDisplayed(), true);
	}
	
	public void saveAndContinueBtn() {
		btn_SaveNCont.click();
	}

}
