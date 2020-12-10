package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US003_US0007_US0015_StoriesPages {

    public US003_US0007_US0015_StoriesPages(){
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

   @FindBy(xpath ="//*[@id='entity-menu']/div/a[2]")
   public WebElement manaccount;

//    @FindBy(xpath="//table/tbody//tr//td[4]")
//    public WebElement accouts;
//
//    @FindBy(xpath="//table/tbody//tr//td[3]")
//    public WebElement balances;

//    public List<WebElement> accounts() {
//        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//table/tbody//tr//td[3]"));
//        return list;
//    }
    @FindBy(how= How.XPATH,using = "//table/tbody//tr//td[4]")
    public static List<WebElement> accountToList;

    @FindBy(how= How.XPATH,using = "//table/tbody//tr//td[3]")
    public static List<WebElement> balanceToList;









}
