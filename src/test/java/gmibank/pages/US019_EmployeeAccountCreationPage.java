package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US019_EmployeeAccountCreationPage {
	
	public US019_EmployeeAccountCreationPage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	@FindBy(xpath = "//a[@href='#']")
	public WebElement accountIcon;
	
	@FindBy(xpath = "//span[text()='Sign in']")
	public WebElement signInLink;
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(xpath = "//button/span[text()='Sign in']")
	public WebElement signInButton;
	
	@FindBy(xpath = "//span[contains(text(),'My Operations')]")
	public WebElement myOperationsMenu;
	
	@FindBy(xpath = "//span[contains(text(),'Manage Accounts')]")
	public WebElement manageAccountsMenu;
	
	@FindBy(xpath = "//span[contains(text(),'Create a new Account')]")
	public WebElement createNewAccountButton;
	
	@FindBy(id = "tp-account-description")
	public WebElement descriptionField;
	
	@FindBy(id = "tp-account-balance")
	public WebElement balanceField;
	
	@FindBy(className = "invalid-feedback")
	public WebElement errorMessage;
	
	@FindBy(id = "tp-account-accountType")
	public WebElement accountType;
	
	@FindBy(id = "tp-account-accountStatusType")
	public WebElement accountStatusType;

	@FindBy(id = "tp-account-employee")
	public WebElement employeeOptions;

}
