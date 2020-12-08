package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US011_DateOnCustomerCreationPage {
	
	public US011_DateOnCustomerCreationPage() {
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
	
	@FindBy(xpath = "//span[contains(text(),'Manage Customers')]")
	public WebElement manageCustomersMenu;
	
	@FindBy(xpath = "//span[contains(text(),'Create a new Customer')]")
	public WebElement createNewCustomerButton;
	
	@FindBy(id = "tp-customer-firstName")
	public WebElement firstNameField;
	
	@FindBy(id = "tp-customer-lastName")
	public WebElement lastNameField;
	
	@FindBy(id = "tp-customer-middleInitial")
	public WebElement middleInitialField;
	
	@FindBy(id = "tp-customer-email")
	public WebElement emailField;
	
	@FindBy(id = "tp-customer-mobilePhoneNumber")
	public WebElement mobilePhoneNumberField;
	
	@FindBy(id = "tp-customer-phoneNumber")
	public WebElement phoneNumberField;
	
	@FindBy(id = "tp-customer-zipCode")
	public WebElement zipCodeField;
	
	@FindBy(id = "tp-customer-address")
	public WebElement addressField;
	
	@FindBy(id = "tp-customer-city")
	public WebElement cityField;
	
	@FindBy(id = "tp-customer-ssn")
	public WebElement ssnField;
	
	@FindBy(id = "tp-customer-createDate")
	public WebElement createDateField;
	
	@FindBy(id = "tp-customer-country")
	public WebElement countryDropdown;
	
	@FindBy(id = "tp-customer-state")
	public WebElement stateField;
	
	@FindBy(id = "tp-customer-user")
	public WebElement userField;
	
	@FindBy(id = "tp-customer-account")
	public WebElement accountDropdown;
	
	@FindBy(id = "tp-customer-zelleEnrolled")
	public WebElement zelleEnrolledField;
	
	@FindBy(id = "save-entity")
	public WebElement saveButton;
	
	//Alternative:"http://gmibank.com/admin/user-management?page=1&sort=createdDate,desc"
	@FindBy(xpath = "//thead/tr[1]/th[7]/*[1]")
	public WebElement dateSort;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	public WebElement lastCreatedLogin;
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/span[1]")
	public WebElement lastCreatedDate;
}
