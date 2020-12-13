package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US008_UserPasswordUpdatePage {

    public US008_UserPasswordUpdatePage() {
      PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//a[@href='#']")
    public WebElement signInMenu ;

    @FindBy (xpath = "//a[@class='dropdown-item']")
    public WebElement signInLink ;

    @FindBy (xpath = "//input[@id='username']")
    public WebElement usernameTextbox ;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextbox ;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy (xpath = "//span[contains(text(),'Taci Korkmaz')]")
    public WebElement taciKorkmazLink;

    @FindBy (xpath = "//span[contains(text(),'Password')]")
    public WebElement passwordSegment;

    @FindBy (xpath = "//input[@name='currentPassword']")
    public WebElement currentPassword;

    @FindBy (xpath = "//input[@name='newPassword']")
    public WebElement newPassword;

    @FindBy (xpath = "//input[@name='confirmPassword']")
    public WebElement confirmPassword;

    @FindBy (xpath = "(//li[@class='point'])[4]")
    public WebElement passwordStrengthFour;

    @FindBy (xpath = "(//li[@class='point'])[5]")
    public WebElement passwordStrengthfive;

    @FindBy (id = "currentPassword")
    public WebElement currentPasswordText;

    @FindBy (id = "newPassword")
    public WebElement newPasswordText;

    @FindBy (id = "confirmPassword")
    public WebElement confirmPasswordText;

    @FindBy (xpath = "//div[text()='The password and its confirmation do not match!']")
    public WebElement confirmPasswordErrorMessage;

}
