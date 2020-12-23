package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US019_EmployeeAccountCreationPage;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class US019_EmployeeAccountCreation {
	
	US019_EmployeeAccountCreationPage page = new US019_EmployeeAccountCreationPage();
	
	@When("I select My Operations Menu -> Manage Accounts -> Create a new Account")
	public void createNewAccount() {
		Driver.waitAndClick(page.myOperationsMenu);
		Driver.waitAndClick(page.manageAccountsMenu);
		Driver.waitAndClick(page.createNewAccountButton);
		Assert.assertEquals("Cannot create a new account",
				"https://gmibank.com/tp-account/new",
				Driver.getDriver().getCurrentUrl());
	}
	
	@Then("Click and leave the description field blank")
	public void leaveTheDescriptionAlone() {
		Driver.waitAndClick(page.descriptionField);
		Driver.waitAndClick(page.balanceField);
	}
	
	@And("Check error message")
	public void checkErrorMessage() {
		Driver.wait(2);
		Assert.assertTrue("There's no error message!",
				page.errorMessage.isDisplayed());
	}
	
	@Then("Balance field shouldn't accept letters, symbols or leaving blank")
	public void balanceFieldFiller() {
		SoftAssert expectedTexts = new SoftAssert();
		List<String> invalidTexts = Arrays.asList(
				"this is invalid",
				"1050is0",
				"999 02",
				"a",
				"$111",
				"",
				"100.0000.00",
				".",
				"100,00"
		);
		for (String text : invalidTexts) {
			Driver.waitAndSendText(page.balanceField, text);
			expectedTexts.assertNotNull(page.errorMessage);
		    page.balanceField.clear();
		}
		expectedTexts.assertAll();
	}
	
	@Then("Check available account types")
	public void checkAccountTypes() {
		Select select = new Select(page.accountType);
		List<WebElement> actualOptions = select.getOptions();
		List<String> texts = actualOptions.stream().map(WebElement::getText).collect(Collectors.toList());
		List<String> expectedTexts = Arrays.asList("CHECKING", "SAVING", "CREDIT_CARD", "INVESTING");
		Assert.assertEquals(expectedTexts, texts);
	}
	
	@Then("Check available account statuses")
	public void checkAccountStatuses() {
		Select select = new Select(page.accountStatusType);
		List<WebElement> actualOptions = select.getOptions();
		List<String> texts = actualOptions.stream().map(WebElement::getText).collect(Collectors.toList());
		List<String> expectedTexts = Arrays.asList("ACTIVE", "SUSPENDED", "CLOSED");
		Assert.assertEquals(expectedTexts, texts);
	}
	
	@Then("Check available employee options")
	public void checkAvailableEmployeeOptions() {
		Select select = new Select(page.employeeOptions);
		List<WebElement> actualOptions = select.getOptions();
		if (actualOptions.size() == 1)	Assert.assertNotEquals("Employee field is empty!","",
				actualOptions.get(0).getText());
		Assert.assertTrue("There is no employee option!", actualOptions.size() > 1);
	}
}
