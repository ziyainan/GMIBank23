package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US005_LoginPageWithInvalidPage {

    public US005_LoginPageWithInvalidPage() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//a[@href='#']")
    public WebElement accountIcon;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInLink;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//a[@href='/account/reset/request']/span")
    public WebElement resetOption;

    @FindBy(xpath = "//span[text()='Register a new account']")
    public WebElement registerOption;

    @FindBy(css="[type='submit']")
    public WebElement signInButton;

    @FindBy(className= "Toastify__toast-body")
    public WebElement errorMessageBackground;

    @FindBy(className= "alert-danger")
    public WebElement errorMessage;

    @FindBy(css= "#username+.invalid-feedback")
    public WebElement userCheck;

    @FindBy(css= "#password+.invalid-feedback")
    public WebElement passwordCheck;


}
