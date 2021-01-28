package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US0016_TransferPage {
    public US0016_TransferPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //US0003
    @FindBy(id = "account-menu")
    public WebElement loginDropdown;

    @FindBy(xpath="//a[@class='dropdown-item'][2]")
    public WebElement register;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//*[@id='strengthBar']/li[2]")
    public WebElement strengthbar;

    @FindBy(xpath="//*[@id='strengthBar']/li[5]")
    public WebElement strengthbar1;

    //email and language bar
    @FindBy(id="account-menu")
    public WebElement accountmenu;

    @FindBy(id="login-item")
    public WebElement loginitem;

    @FindBy(name="username")
    public WebElement username;

    @FindBy(id="firstPassword")
    public WebElement pass;

    @FindBy(xpath="//*[@type='submit']")
    public WebElement submit;

//    @FindBy(id="account-menu")
//    public WebElement account;

    @FindBy(xpath ="//*[@id='account-menu']/div/a[1]")
    public WebElement userinfo;

    @FindBy(id ="email")
    public WebElement email;

    @FindBy(xpath ="//*[@class='invalid-feedback']")
    public WebElement invalid;

    @FindBy(id ="langKey")
    public WebElement language;

    //US0015
    @FindBy(id="entity-menu")
    public WebElement myoperations;

    @FindBy(xpath ="//a[@href='/customer/tp-customer-accounts/41422']")
    public WebElement manaccount;

    @FindBy(css ="button.btn")
    public static List<WebElement> transactionBttn;

    @FindBy(how= How.XPATH,using = "//table/tbody//tr//td[2]")
    public static List<WebElement> accountType;

    @FindBy(how= How.XPATH,using = "//table/tbody//tr//td[3]")
    public static List<WebElement> balance;

    @FindBy(how= How.XPATH,using = "//table/thead/tr/th[text()='Amount']")
    public WebElement transAmount;

    @FindBy(id="fromAccountId")
    public WebElement accountid;

    @FindBy(xpath="//a[contains(text(),'Transfer Money')]")
    public WebElement tranferMoneyBttn;

    @FindBy(name="toAccountId")
    public WebElement toPart;

    @FindBy(name="balance")
    public WebElement balanceplace;

    @FindBy(name="balancecent")
    public WebElement cent;

    @FindBy(id="description")
    public WebElement description;

    @FindBy(xpath="//div[@class='invalid-feedback']")
    public WebElement firstinvalidate;

    @FindBy(xpath="//div[contains(text(),'This field is required.')]")
    public WebElement secondinvalidate;


    @FindBy(id="make-transfer")
    public WebElement maketransfer;

    @FindBy(xpath="//div[@class='Toastify__toast-body']")
    public WebElement success;

}
