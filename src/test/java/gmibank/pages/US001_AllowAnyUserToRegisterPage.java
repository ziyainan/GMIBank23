package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US001_AllowAnyUserToRegisterPage {

    public US001_AllowAnyUserToRegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement registerIcon;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement register;

    @FindBy(id = "ssn")
    public WebElement ssnBox;

    @FindBy(name = "firstname")
    public WebElement firstNameBox;

    @FindBy(name = "lastname")
    public WebElement lastNameBox;

    @FindBy(name = "address")
    public WebElement addressBox;

    @FindBy(name = "mobilephone")
    public WebElement phoneNumberBox;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "firstPassword")
    public WebElement newPasswordBox;

    @FindBy(id = "secondPassword")
    public WebElement secondPasswordBox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")  // //*[contains(text(),'Registration saved!']
    public WebElement registrationConfirmation;




}
