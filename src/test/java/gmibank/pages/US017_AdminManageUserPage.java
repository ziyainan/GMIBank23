package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US017_AdminManageUserPage {
   public US017_AdminManageUserPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement arrow;

    @FindBy(id = "login-item")
    public WebElement dropdownSignIn;

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SignIn;

    @FindBy(xpath = "(//a[@aria-haspopup])[2]")
    public WebElement administration;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement userManagement;

    @FindBy(xpath = "//tbody/tr[@id='pixie_manager']/td[4]/button[1]")
    public WebElement pixieManager;

    @FindBy(xpath = "//tbody/tr[@id='pixie_employee']/td[4]/button[1]")
    public WebElement pixieEmployee;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/nav[1]/ul[1]/li[4]/a[1]")
    public WebElement pageTwo;

    @FindBy(xpath = "//tbody/tr[@id='pixie_admin']/td[4]/button[1]")
    public WebElement pixieAdmin;

    @FindBy(xpath = "//tbody/tr[@id='pixie_user']/td[4]/button[1]")
    public WebElement pixieUser;

    @FindBy(xpath = "//div[contains(text(),'A user is updated with identifier pixie_user')]")
    public WebElement userConfirmation;

    @FindBy(xpath = "//tbody/tr[@id='pixie_manager']/td[10]/div[1]/a[1]")
    public WebElement viewButton;

    @FindBy(xpath = "//tbody/tr[@id='pixie_manager']/td[10]/div[1]/a[2]")
    public WebElement editButton;

    @FindBy(xpath = "//tbody/tr[@id='pixie_manager']/td[10]/div[1]/a[3]")
    public WebElement deleteButton;

 @FindBy(xpath = "//h5")
 public WebElement deleteMessage;

    @FindBy(xpath = "//span[contains(text(),'ROLE_MANAGER')]")
    public WebElement roleManager;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstnameBox;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement saveButton;

}
