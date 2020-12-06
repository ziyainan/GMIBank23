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
	
	@FindBy(xpath = "//span[contains(text(),'Administration')]")
	public WebElement administrationMenu;
	
	@FindBy(xpath = "//span[contains(text(),'User management')]")
	public WebElement userManagementMenu;
	
	@FindBy(xpath = "//span[contains(text(),'Create a new user')]")
	public WebElement createNewUserButton;
	
	@FindBy(id = "login")
	public WebElement loginField;
	
	@FindBy(id = "firstName")
	public WebElement firstNameField;
	
	@FindBy(id = "lastName")
	public WebElement lastNameField;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id  = "authorities")
	public WebElement authoritiesField;
	
	@FindBy(css = "[type='submit']")
	public WebElement submitButton;
	
	//Alternative:"http://gmibank.com/admin/user-management?page=1&sort=createdDate,desc"
	@FindBy(xpath = "//thead/tr[1]/th[7]/*[1]")
	public WebElement dateSort;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	public WebElement lastCreatedLogin;
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/span[1]")
	public WebElement lastCreatedDate;
}
