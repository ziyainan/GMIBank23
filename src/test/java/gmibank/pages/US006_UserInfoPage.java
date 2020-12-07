package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US006_UserInfoPage {
    public US006_UserInfoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//li[@id='account-menu']")
    public WebElement accountMenu ;

    @FindBy (xpath = "//a[@id='login-item']")
    public WebElement signInLink ;

    @FindBy (xpath = "//input[@id='username']")
    public WebElement usernameTextbox ;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextbox ;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy (xpath = "//span[contains(text(),'Linda Pine')]")
    public WebElement lindaPineLink;

    @FindBy (xpath = "//span[contains(text(),'User Info')]")
    public WebElement userInfoSegment;

    @FindBy (xpath = "//label[contains(text(),'First Name')]")
    public WebElement firstNameText;

    @FindBy (xpath = "//label[contains(text(),'Last Name')]")
    public WebElement lastNameText;

    @FindBy (xpath = "//label[contains(text(),'Email')]")
    public WebElement emailText;

    @FindBy (xpath = "//label[contains(text(),'Language')]")
    public WebElement languageText;

    @FindBy (xpath = "//select[@id='langKey']")
    public WebElement languageDropDown;

    @FindBy (xpath = "//input[@id='firstName']")
    public WebElement firstnameTextbox;

    @FindBy (xpath = "//input[@id='lastName']")
    public WebElement lastnameTextbox;

    @FindBy (xpath = "//input[@id='email']")
    public WebElement emailTextbox;

}
