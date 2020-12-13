package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US0002_RegistrationPageWebElements {

    public US0002_RegistrationPageWebElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement arrow;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement dropdownRegister;

    @FindBy(name = "ssn")
    public WebElement ssnBox;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement ssnBlankMessage;

    @FindBy(name = "firstname")
    public WebElement firstNameBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement firstNameBlankMessage;

    @FindBy(name = "lastname")
    public WebElement lastNameBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement lastNameBlankMessage;

    @FindBy(name = "address")
    public WebElement addressBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[5]")
    public WebElement addressMessage;

    @FindBy(name = "mobilephone")
    public WebElement mobilePhoneBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[4]")
    public WebElement mobilePhoneInvalidMessage;

    @FindBy(name = "username")
    public WebElement usernameBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[3]")
    public WebElement usernameBlankMessage;

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[4]")
    public WebElement emailBlankMessage;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[5]")
    public WebElement emailInvalidMessage;

    @FindBy(name = "firstPassword")
    public WebElement newPasswordBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[5]")
    public WebElement newPasswordMessage;

    @FindBy(name = "secondPassword")
    public WebElement newPasswordConfirmationBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[6]")
    public WebElement newPasswordConfirmationMessage;

    @FindBy(id = "register-submit")
    public WebElement register;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")  // //*[contains(text(),'Registration saved!']
    public WebElement registrationConfirmation;

}
