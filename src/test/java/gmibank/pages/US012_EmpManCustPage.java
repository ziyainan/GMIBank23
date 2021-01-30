package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US012_EmpManCustPage {

     @FindBy(id = "entity-menu")
     public WebElement myOperation;

     @FindBy(linkText = "Manage Customers")
     public WebElement manageCustomers;

}
