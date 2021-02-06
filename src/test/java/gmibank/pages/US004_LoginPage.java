package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US004_LoginPage extends BasePage{

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

    @FindBy(id="account-menu")
    public WebElement accountIconLogout;

    @FindBy(linkText = "Sign out")
    public WebElement signOut;

    @FindBy(linkText = "SIGN IN AGAIN")
    public WebElement loggedOut;
     //
    /*
    public void login(){
        String username = ConfigurationReader.getProperty("AdminUsername") ;
        String password = ConfigurationReader.getProperty("password1") ;

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

     */
}
