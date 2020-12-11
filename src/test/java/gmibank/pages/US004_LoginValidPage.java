package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US004_LoginValidPage {

    //   public WebElement cancelButton;

    public US004_LoginValidPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement myloginDropdown;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement mysignInButton;

    @FindBy(id = "username")
    public WebElement myusername;

    @FindBy( id = "password")
    public WebElement mypassword;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement myLoginButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement myCancelButton;


}

