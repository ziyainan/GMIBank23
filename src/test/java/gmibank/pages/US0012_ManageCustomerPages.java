package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US0012_ManageCustomerPages {
   public US0012_ManageCustomerPages(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
   @FindBy (xpath = "//span[contains(text(),'My Operations')]")
    public WebElement myOperationsLink;

    @FindBy (xpath = "//span[contains(text(),'Manage Customers')]")
    public WebElement manageCustomersLink;

    @FindBy (xpath = "//span[contains(text(),'First Name')]")
    public WebElement firstnameText;

    @FindBy (xpath = "//span[contains(text(),'Last Name')]")
    public WebElement lastnameText;

    @FindBy (xpath = "//span[contains(text(),'Middle Initial')]")
    public WebElement middleInitialText;

    @FindBy (xpath = "//span[contains(text(),'Email')]")
    public WebElement emailText;

    @FindBy (xpath = "//span[contains(text(),'Mobile Phone Number')]")
    public WebElement mobilePhoneNumberText;

    @FindBy (xpath = "//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[7]/span[1]")
    public WebElement phoneNumberText;

    @FindBy (xpath = "//span[contains(text(),'Address')]")
    public WebElement addressText;

    @FindBy (xpath = "//span[contains(text(),'Create Date')]")
    public WebElement createDateText;

    @FindBy (xpath = "//tbody/tr[1]/td[10]/div[1]/a[1]")
    public WebElement viewButton;

    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]")
    public WebElement editButtoninView;

    @FindBy (xpath = "//input[@id='tp-customer-firstName']")
    public WebElement firstnameTextbox;

    @FindBy (xpath = "//input[@id='tp-customer-mobilePhoneNumber']")
    public WebElement mobilePhoneTextbox;

    @FindBy (xpath = "//select[@id='tp-customer-account']")
    public WebElement accountDropdown;

    @FindBy (xpath = "//tbody/tr[1]/td[10]/div[1]/a[3]")
    public WebElement deleteButton;

    @FindBy (xpath = "//span[text()='Confirm delete operation']")
    public WebElement deletionMessage;

}
