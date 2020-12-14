package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US013_EmployeeCreateNewAccountPage {
    public US013_EmployeeCreateNewAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(id = "login-item")
    public WebElement signIn;

    @FindBy(xpath = "//*[contains(text(),'Sign out')]")
    public WebElement signOut;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(id = "entity-menu")
    public WebElement myOperations;

    @FindBy(xpath = "//*[contains(text(),'Manage Accounts')]")
    public WebElement manageAccounts;

    @FindBy(id = "jh-create-entity")
    public WebElement createNewAccount;

    @FindBy(id = "tp-account-description")
    public WebElement description;

    @FindBy(id = "tp-account-balance")
    public WebElement balance;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountType;

    @FindBy(id = "tp-account-accountStatusType")
    public WebElement accountStatusType;

    @FindBy(id = "tp-account-employee")
    public WebElement employee;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'This field is required.')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[contains(text(),'Ziya Employee')]")
    public WebElement activeUser;

    @FindBy(xpath = "//*[contains(text(),'Accounts')]")
    public WebElement accountsPage;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement toastify;

}
