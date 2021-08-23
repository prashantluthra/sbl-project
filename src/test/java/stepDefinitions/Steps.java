package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ApplyAddressPage;
import pageObjects.ApplyEmployeesPage;
import pageObjects.ApplyFinancingNeedsPage;
import pageObjects.ApplyInceptionDatePage;
import pageObjects.ApplyIndustryPage;
import pageObjects.ApplyInitialPage;
import pageObjects.ApplyLoanPage;
import pageObjects.ApplyLoginPage;
import pageObjects.ApplyOwnersPage;
import pageObjects.ApplyPasswordPage;

public class Steps {
	
	private ConfigSteps configSteps;
	private WebDriver driver;
	ApplyInitialPage applyInitialPage;
	ApplyLoanPage applyLoanPage;
	ApplyFinancingNeedsPage applyFinancingNeedsPage;
	ApplyInceptionDatePage applyInceptionDatePage;
	ApplyIndustryPage applyIndustryPage;
	ApplyAddressPage applyAddressPage;
	ApplyEmployeesPage applyEmployeesPage;
	ApplyPasswordPage applyPasswordPage;
	ApplyOwnersPage applyOwnersPage;
	ApplyLoginPage applyLoginPage;
	
	String baseURL = "https://qa-app02.smartbizloans.com";
	
	public Steps(ConfigSteps configSteps) {
		this.driver = configSteps.driver;
	}
	
	@Given("I am on sba7a apply page")
	public void i_am_on_sba7a_apply_page() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL + "/apply?partner_id=smartbiz");
	}
	
	@When("I select {string}")
	public void i_select(String step1Option) {
		applyInitialPage = new ApplyInitialPage(driver);
		applyInitialPage.validateURL(baseURL+"/apply?partner_id=smartbiz");
		applyInitialPage.validateFormFields();
		applyInitialPage.set_step1(step1Option);
	}
	
	@When("I select {string} option")
	public void i_select_option(String loanPreferenceOption) {
	    applyInitialPage.set_loanPreference(loanPreferenceOption);
	}
	
	@When("I add my peronal info as {string}, {string}, {string}, {string}, {string}, {string}")
	public void i_add_my_peronal_info_as(String firstname, String lastname, String email, String phoneNo, String businessName, String hearAboutUs) {
	    applyInitialPage.add_PersonalInfo(firstname, lastname, email, phoneNo, businessName, hearAboutUs);
	}
	
	@When("I accept terms and conditions")
	public void i_accept_terms_and_conditions() {
	    applyInitialPage.check_TC(true);
	}
	
	@When("I click on Continue to PreQualify button")
	public void i_click_on_continue_to_pre_qualify_button() {
		applyInitialPage.contToPreQualifyBtn();
	}
	
	@When("I click on Lets get started button")
	public void i_click_on_lets_get_started_button() {
		applyLoanPage = new ApplyLoanPage(driver);
		applyLoanPage.validateButton();
	    applyLoanPage.letsGetStartedBtn();
	}
	
	@When("I select funding option {string}")
	public void i_select_funding_option(String fundOption) {
		applyFinancingNeedsPage = new ApplyFinancingNeedsPage(driver);
		applyFinancingNeedsPage.validateFinNeedsButtons();
		applyFinancingNeedsPage.set_fundingPreference(fundOption);
	}
	
	@When("I click on Save & continue button on financing needs page")
	public void i_click_on_save_continue_button_on_financing_needs_page() {
		applyFinancingNeedsPage.saveAndContinueBtn();
	}
	
	@When("I select business started in {string}")
	public void i_select_business_started_in(String yrsOption) {
		applyInceptionDatePage = new ApplyInceptionDatePage(driver);
		applyInceptionDatePage.validateIncDatePageButtons();
		applyInceptionDatePage.set_yrsOldPreference(yrsOption);
	}
	
	@When("I click on Save & Continue button on inception date page")
	public void i_click_on_save_continue_button_on_inception_date_page() {
		applyInceptionDatePage.saveAndContinueBtn();
	}
	
	@When("I select {string} option from Business Industry drop down")
	public void i_select_option_from_business_industry_drop_down(String industryOption) {
		applyIndustryPage = new ApplyIndustryPage(driver);
	    applyIndustryPage.validateBIDropDown();
	    applyIndustryPage.set_BusinessType(industryOption);
	}
	
	@When("I click on Save & Continue button on industry page")
	public void i_click_on_save_continue_button_on_industry_page() {
		applyIndustryPage.saveAndContinueBtn();
	}
	
	
	@When("I enter address {string} auto suggestion will be displayed")
	public void i_enter_address_auto_suggestion_will_be_displayed(String address) {
		applyAddressPage = new ApplyAddressPage(driver);
	    applyAddressPage.validateAddressBox();
	    applyAddressPage.type_businessAddress(address);
	}
	@When("I select auto suggested option by hovering over it")
	public void i_select_auto_suggested_option_by_hovering_over_it() {
	    applyAddressPage.select_suggestedAddress();
	}
	@When("I click outside address textbox")
	public void i_click_outside_address_textbox() {
	    //applyAddressPage.clickSuiteApt();
	}
	
	@When("I click on Save & Continue button on address page")
	public void i_click_on_save_continue_button_on_address_page() {
		applyAddressPage.saveAndContinueBtn();
	}
	
	@When("I select employees {string}")
	public void i_select_employees(String noOfEmpOption) {
		applyEmployeesPage = new ApplyEmployeesPage(driver);
		applyEmployeesPage.validateEmpPageButtons();
		applyEmployeesPage.set_noOfEmpPreference(noOfEmpOption);
	}
	
	@When("I click on Save & Continue button on employees page")
	public void i_click_on_save_continue_button_on_employees_page() {
		applyEmployeesPage.saveAndContinueBtn();
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		applyPasswordPage = new ApplyPasswordPage(driver);
	    applyPasswordPage.validatePwdPageButtons();
	    applyPasswordPage.set_password(password);
	}
	
	@When("I click on Save & Continue button on password page")
	public void i_click_on_save_continue_button_on_password_page() {
		applyPasswordPage.saveAndContinueBtn();
	}
	
	@When("I check success message it should have users first name {string}")
	public void i_check_success_message_it_should_have_users_first_name(String firstname) {
		applyOwnersPage = new ApplyOwnersPage(driver);
		applyOwnersPage.validateFirstName(firstname);
	}
	
	@When("I click on logout button")
	public void i_click_on_logout_button() {
		applyOwnersPage = new ApplyOwnersPage(driver);
	    applyOwnersPage.validateOwnersPageButtons();
	    applyOwnersPage.logOutBtn();
	}
	
	@When("I select {string} on modal dialog")
	public void i_select_on_modal_dialog(String string) {
		applyOwnersPage.signMeOutBtn();
	}
	@When("I enter {string} and {string}")
	public void i_enter_and(String email, String password) {
		applyLoginPage = new ApplyLoginPage(driver);
	    applyLoginPage.set_Email(email);
	    applyLoginPage.set_Password(password);
	}
	@When("I click on login button")
	public void i_click_on_login_button() {
	    applyLoginPage.click_LoginBtn();
	}
	@Then("I will be able to login to the application")
	public void i_will_be_able_to_login_to_the_application() {
	    applyOwnersPage.validateOwnersPageButtons();
	}
}
