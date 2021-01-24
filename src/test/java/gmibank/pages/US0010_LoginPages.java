package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US0010_LoginPages {


        public US0010_LoginPages(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id="account-menu")
    public WebElement accountIcon;

    @FindBy(id = "login-item")
    public WebElement signInIcon;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitSignIn;

    @FindBy(id = "entity-menu")
    public WebElement myOperations;


    @FindBy(xpath = "//li[@id ='entity-menu']/div/a[1]")
            public WebElement manageCustomers;

    @FindBy(css = "#jh-create-entity")
    public WebElement NewCustomer;


    @FindBy(css = "#tp-customer-city")
    public WebElement city;


    @FindBy(css = "#tp-customer-country")
    public WebElement country;


    @FindBy(css = "#tp-customer-state")
    public WebElement state;
}



