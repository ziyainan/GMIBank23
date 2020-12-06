package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US009_CreateCustomerPage {

public US009_CreateCustomerPage() {

    PageFactory.initElements(Driver.getDriver(),this);
}

//@FindBy()


}


//@FindBy(id = "UserName")
//    public WebElement userName;
//
//    @FindBy(id = "Password")
//    public WebElement password;
//
//    @FindBy(id = "btnSubmit")
//    public WebElement signInButton;
//
//
//}
//@FindBy(id = "DTE_Field_first_name")
//    public WebElement firstName;
//
//    @FindBy(id = "DTE_Field_last_name")
//    public WebElement lastName;
//
//    @FindBy(id = "DTE_Field_position")
//    public WebElement position;
//
//    @FindBy(id = "DTE_Field_office")
//    public WebElement office;
//
//    @FindBy(id = "DTE_Field_extn")
//    public WebElement extensionNumber;
//
//    @FindBy(id = "DTE_Field_start_date")
//    public WebElement startDate;
//
//    @FindBy(id = "DTE_Field_salary")
//    public WebElement salary;
//
//    @FindBy(css = ".btn")
//    public WebElement createBox;
//
//    @FindBy(xpath = "//input[@type='search']")
//    public WebElement searchBox;
//
//    @FindBy(xpath = "//td[@class='sorting_1']")
//    public WebElement nameField;
//}