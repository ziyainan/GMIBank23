package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_11_Creation_Customer {

    public US_11_Creation_Customer(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css="[type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='My Operations']")
    public WebElement myoperationButton;

    @FindBy(xpath = "//span[text()='Manage Customers']")
    public WebElement manageCustomer;

    @FindBy(id = "jh-create-entity")
    public WebElement cnewCustomer;

    @FindBy(id = "search-ssn")
    public WebElement cssn;

    @FindBy(id = "tp-customer-firstName")
    public WebElement cfirstname;

    @FindBy(id = "tp-customer-lastName")
    public WebElement clastname;

    @FindBy(id = "tp-customer-middleInitial")
    public WebElement cmiddle;

    @FindBy(id = "tp-customer-email")
    public WebElement cemail;

    @FindBy(id = "tp-customer-mobilePhoneNumber")
    public WebElement cmobilPhone;

    @FindBy(id = "tp-customer-phoneNumber")
    public WebElement cphone;

    @FindBy(id = "tp-customer-zipCode")
    public WebElement czip;

    @FindBy(id = "tp-customer-address")
    public WebElement caddress;

    @FindBy(id = "tp-customer-city")
    public WebElement ccity;

    @FindBy(id = "tp-customer-ssn")
    public WebElement cssn2;

    @FindBy(id = "tp-customer-createDate")
    public WebElement cndate;

    @FindBy(id = "tp-customer-country")
    public WebElement ccountry;

    @FindBy(id = "tp-customer-state")
    public WebElement cstate;

    @FindBy(id = "tp-customer-user")
    public WebElement cuser;

    @FindBy(id = "tp-customer-account")
    public WebElement caccount;

    @FindBy(id = "tp-customer-zelleEnrolled")
    public WebElement czelle;

    @FindBy(id = "save-entity")
    public WebElement csaveButton;

    @FindBy(id = "cancel-save")
    public WebElement cback;

    @FindBy(linkText = "Home")
    public WebElement homelink;

}
