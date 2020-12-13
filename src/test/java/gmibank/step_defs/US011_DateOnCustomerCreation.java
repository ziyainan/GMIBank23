package gmibank.step_defs;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US011_DateOnCustomerCreationPage;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.DateUtil;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US011_DateOnCustomerCreation {
	
	static Faker fake = new Faker();
	US011_DateOnCustomerCreationPage page = new US011_DateOnCustomerCreationPage();
	
	@Given("I visit GMI Bank")
	public void visitGMIBank() {
		String url = ConfigurationReader.getProperty("gmibank_login_url");
		Driver.getDriver().get(url);
		Assert.assertEquals(
				"Cannot get into the website",
				url,
				Driver.getDriver().getCurrentUrl());
	}
	
	@Given("I sign in as valid employee")
	public void signInAsValidEmployee() {
		Driver.waitAndClick(page.accountIcon);
		Driver.waitAndClick(page.signInLink);
		Driver.waitAndSendText(page.username, ConfigurationReader.getProperty("employee_username"));
		Driver.waitAndSendText(page.password, ConfigurationReader.getProperty("employee_password"));
		Driver.waitAndClick(page.signInButton);
		Assert.assertNotNull("Cannot login with given credentials",
				page.myOperationsMenu);
	}
	
	@When("I select My Operations Menu -> Management Customers -> Create New Customer")
	public void createNewUser() {
		Driver.waitAndClick(page.myOperationsMenu);
		Driver.waitAndClick(page.manageCustomersMenu);
		Driver.waitAndClick(page.createNewCustomerButton);
		Assert.assertEquals("Cannot create a new user",
				"https://gmibank.com/tp-customer/new",
				Driver.getDriver().getCurrentUrl());
	}
	
	@And("Fill out necessary information")
	public void fillOut() throws InterruptedException {
		String firstUrl = Driver.getDriver().getCurrentUrl();
		//Driver.waitAndSendText(page.loginField, DateUtil.todaysDate5());
		Driver.waitAndSendText(page.firstNameField, fake.name().firstName());
		Driver.waitAndSendText(page.lastNameField, fake.name().lastName());
		Driver.waitAndSendText(page.middleInitialField, String.valueOf((char) ('A' + fake.number().numberBetween(0, 26))));
		Driver.waitAndSendText(page.emailField, fake.internet().safeEmailAddress());
		Driver.waitAndSendText(page.mobilePhoneNumberField,
				fake.number().digits(3) + "-" + fake.number().digits(3) + "-" + fake.number().digits(4));
		Driver.waitAndSendText(page.phoneNumberField,
				fake.number().digits(3) + "-" + fake.number().digits(3) + "-" + fake.number().digits(4));
		Driver.waitAndSendText(page.zipCodeField, fake.address().zipCode());
		Driver.waitAndSendText(page.addressField, fake.address().fullAddress());
		Driver.waitAndSendText(page.cityField, fake.address().city());
		Driver.waitAndSendText(page.ssnField, fake.idNumber().ssnValid());
	}
	
	@Then("Created date should be in the future")
	public void createdDateCheckerFuture() throws InterruptedException {
		String futureDate = String.valueOf(Long.parseLong(DateUtil.todaysDate7()) + 10000);
		Driver.waitAndSendText(page.createDateField,futureDate);
	}
	
	@Then("Created date should be in the past")
	public void createdDateCheckerPast() throws InterruptedException {
		String pastDate = String.valueOf(Long.parseLong(DateUtil.todaysDate7()) - 10000);
		Driver.waitAndSendText(page.createDateField,pastDate);
	}
	
	@Then("Created date should be as month, day, year, hour and minute")
	public void createdDateFormatChecker() throws InterruptedException {
		Driver.waitAndSendText(page.createDateField, DateUtil.todaysDate7());
	}
	
	@Then("User can choose a user from the registration and leave it as be blank")
	public void chooseUser() {
		//Leave blank
		//Select user = new Select(page.userField);
		//BrowserUtils.selectRandomTextFromDropdown(user);
		
	}
	
	@Then("There user can choose an account created on manage accounts")
	public void manageAccounts() {
		Select account = new Select(page.accountDropdown);
		BrowserUtils.selectRandomTextFromDropdown(account);
	}
	
	@Then("User can select Zelle Enrolled optionally")
	public void zelleCheck() {
		Driver.waitAndClick(page.zelleEnrolledField);
	}
	
	@Then("save it")
	public void saveIt() throws InterruptedException {
		Thread.sleep(1000);
		String firstUrl = Driver.getDriver().getCurrentUrl();
		Driver.waitAndClick(page.saveButton);
		Thread.sleep(1500);
		Assert.assertNotEquals("User unable to be saved",
				firstUrl,
				Driver.getDriver().getCurrentUrl());
	}
	
	@Then("it should not save it")
	public void itShouldNotSaveIt() throws InterruptedException {
		Thread.sleep(2000);
		String firstUrl = Driver.getDriver().getCurrentUrl();
		Driver.waitAndClick(page.saveButton);
		Thread.sleep(2000);
		Assert.assertEquals("User able to be saved",
				firstUrl,
				Driver.getDriver().getCurrentUrl());
	}
}
