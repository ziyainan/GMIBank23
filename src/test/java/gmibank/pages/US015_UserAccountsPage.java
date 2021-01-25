package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US015_UserAccountsPage {
	@FindBy(id = "account-menu")
	public WebElement loginDropdown;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(id = "login-item")
	public WebElement loginMenu;
	@FindBy(name = "username")
	public WebElement username;
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement submit;
	@FindBy(id = "entity-menu")
	public WebElement myOperations;
	@FindBy(xpath = "//a[@href='/customer/tp-customer-accounts/41422']")
	public WebElement myAccounts;
	@FindBy(css = "button.btn")
	public List<WebElement> transaction;
	@FindBy(how = How.XPATH, using = "//table/tbody//tr//td[2]")
	public List<WebElement> accountType;
	@FindBy(how = How.XPATH, using = "//table/tbody//tr//td[3]")
	public List<WebElement> balance;
	@FindBy(how = How.XPATH, using = "//table/thead/tr/th[text()='Amount']")
	public WebElement amount;
	
	public US015_UserAccountsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
}
