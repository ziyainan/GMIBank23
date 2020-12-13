package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US014_DateCreationOfAccountPage {

    public US014_DateCreationOfAccountPage(){ PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//input[@id='username']")
    public WebElement usernameTextbox ;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextbox ;

    @FindBy(xpath = "//li[@class=\"dropdown nav-item\"]")
    public WebElement loginDropDown;

    @FindBy(xpath = "//div//button[@class=\"btn btn-primary\"]")
    public WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),'My Operations')]")
    public WebElement myOperations;

    @FindBy(xpath = "//span[contains(text(),'Manage Accounts')]")
    public WebElement manageAccounts;

    @FindBy(xpath = "//span[contains(text(),'Create a new Account')]")
    public WebElement createNewAccount;

    @FindBy(xpath = "//div//input[@name=\"description\"]")
    public WebElement description;

    @FindBy(xpath = "//div//input[@name='balance']")
    public WebElement balance;

    @FindBy(xpath = "//input[@name='createDate']")
    public WebElement date;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    public WebElement signIn;

//    @FindBy(xpath = "//table//tr//td[2]")
//    public WebElement createdAccount;

      @FindBy(xpath = "//table//tr//td[2][contains(text(),'Z12')]")
      public WebElement createdAccount;



}
