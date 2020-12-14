package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmiPage {

    public GmiPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}
    @FindBy(xpath ="//li[@id='account-menu']/a")
    public WebElement usericon;

    @FindBy(xpath = "//*[@id=\"login-item\"]/span")
    public  WebElement signin;

    @FindBy(xpath="//*[@id=\"login-page\"]/div/form/div[3]/button[2]/span")
    public WebElement signin2;

    @FindBy(xpath ="//*[@id=\"entity-menu\"]/a/span")
    public WebElement MyOperations;

    @FindBy(xpath="//*[@id=\"entity-menu\"]/div/a[1]/span")
    public WebElement ManCustomer;

    @FindBy(xpath ="//*[@id=\"jh-create-entity\"]/span")
    public WebElement createUser;

    @FindBy(xpath ="//*[@id=\"login\"]")
    public WebElement loginName;

    @FindBy(xpath ="//li[@id='account-menu']/div/a[2]")
    public WebElement registerLink;

    @FindBy(css="#tp-customer-ssn")
    public WebElement ssnBox;

    @FindBy(xpath ="//*[.='Your SSN is invalid']")
    public WebElement ssnAlert;

    @FindBy(css ="#tp-customer-firstName")
    public WebElement firstName;

    @FindBy(css ="#tp-customer-lastName")
    public WebElement lastName;

    @FindBy(css="#tp-customer-middleInitial")
    public WebElement middleName;

    @FindBy(css ="#tp-customer-address")
    public WebElement adress;

    @FindBy(css ="#tp-customer-mobilePhoneNumber")
    public WebElement mobilePhone;

    @FindBy(css= "#tp-customer-phoneNumber")
    public WebElement phoneNumber;

    @FindBy(xpath ="//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath ="//input[@name='password']")
    public WebElement password;

    @FindBy(css ="#tp-customer-email")
    public WebElement email;

    @FindBy(css="#tp-customer-zipCode")
    public WebElement zipCode;

    @FindBy(xpath ="//input[@name='firstPassword']")
    public WebElement firstPassword;

    @FindBy(xpath ="//input[@name='secondPassword']")
    public WebElement secondPassword;

    @FindBy(xpath ="//*[@id='account-menu']/a/span")
    public WebElement accountMenu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

  //  @FindBy(xpath = "//button[@type='signin']")
 //   public WebElement signin;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]/span")
    public WebElement passMenu;

    @FindBy(xpath ="//*[@id='currentPassword']")
    public WebElement curPass;

    @FindBy(xpath = "//*[@id='newPassword']")
    public WebElement newPass;

    @FindBy(xpath ="//*[@id='confirmPassword']")
    public WebElement conPass;

    @FindBy(css="#tp-customer-city")
    public WebElement cityName;

    @FindBy(css="#tp-customer-state")
    public WebElement stateName;

    @FindBy(css="#tp-customer-country")
    public WebElement countryName;
    @FindBy(css="#tp-customer-user")
    public WebElement userType;

    @FindBy(css="#tp-customer-account > option:nth-child(2)")
    public WebElement custAccount;

    @FindBy(xpath ="//*[@id=`save-entity`]/span")
    public WebElement bttnSave;

    @FindBy(xpath="/div/div[1]/span/strong")
    public WebElement confMessage;




}
