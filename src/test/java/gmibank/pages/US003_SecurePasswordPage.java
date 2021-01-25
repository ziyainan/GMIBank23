package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US003_SecurePasswordPage extends BasePage{


    @FindBy(id="account-menu")
    public WebElement accountIcon;

    @FindBy(linkText = "Register")
    public WebElement registerIcon;

    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextBox;

    @FindBy(id = "secondPassword")
    public WebElement passwordTextBox;




}
