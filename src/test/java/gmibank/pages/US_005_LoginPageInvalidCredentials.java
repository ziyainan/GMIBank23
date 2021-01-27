package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_005_LoginPageInvalidCredentials {

    public US_005_LoginPageInvalidCredentials() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath="//li[@id='account-menu']")
    public WebElement personIcon;

    @FindBy(partialLinkText="Sign in")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement errorMessage;

    @FindBy(linkText = "Did you forget your password?")
    public WebElement forgetPasswordButton;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement resetPasswordMessage;

    @FindBy(xpath = "//span[.='Register a new account']")
    public WebElement registrationsButton;

    @FindBy(xpath = "//h1[@id='register-title']")
    public WebElement registrationValidate;

}
