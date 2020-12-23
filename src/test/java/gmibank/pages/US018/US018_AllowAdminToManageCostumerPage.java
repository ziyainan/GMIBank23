package gmibank.pages.US018;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US018_AllowAdminToManageCostumerPage {

    public US018_AllowAdminToManageCostumerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement manIcon;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement signIn;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),'Administration')]")
    public WebElement administrationDropDown;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement userManagement;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[2]")
    public WebElement viewButton;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[2]")
    public WebElement editButton;

    @FindBy(id = "firstName")
    public WebElement nameBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement editAButton;

    @FindBy(className = "Toastify__toast-body" )
    public WebElement toastAnimation;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement deleteButton;
}
