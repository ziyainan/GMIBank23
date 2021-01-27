package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_006_UserInfoSegment {

    public US_006_UserInfoSegment() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement usernameValidate ;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[1]")
    public WebElement userInfoButton;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//select[@id='langKey']")
    public WebElement languageBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton;

//    @FindBy(xpath = "(//a[@class='dropdown-item'])[5]")
//    public WebElement signOutButton;
@FindBy(linkText = "Sign out")
public WebElement signOut;

    @FindBy(xpath = "(//input[@value='Team26'])[1]")
    public WebElement currentFirstName;

    @FindBy(xpath = "(//input[@value='Team26'])[2]")
    public WebElement currentLastName;

    @FindBy(xpath = "(//input[@value='team26employee@gmail.com'])")
    public WebElement currentEmail;


}
