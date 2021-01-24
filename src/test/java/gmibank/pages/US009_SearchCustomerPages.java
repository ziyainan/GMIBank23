package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class US009_SearchCustomerPages {


        public US009_SearchCustomerPages() {

            PageFactory.initElements(Driver.getDriver(),this);
        }


        @FindBy(id ="account-menu")
        public WebElement menu;

        @FindBy(id ="login-item")
        public WebElement login;

        @FindBy(id ="username")
        public WebElement usernamebox;

        @FindBy(id ="password")
        public WebElement passwordbox;

        @FindBy(css="[type='submit']")
        public WebElement sign;

        //@FindBy(xpath ="//*[@id=\"login-page\"]/div/form/div[3]/button[2]")
        //public WebElement sign;

        @FindBy(id ="entity-menu")
        public WebElement getmenu;

        @FindBy(xpath ="//*[@id=\"entity-menu\"]/div/a[1]")
        public WebElement managecustomers;

        @FindBy(id ="jh-create-entity")
        public WebElement createnewcustomer;

        @FindBy(id ="search-ssn")
        public WebElement searchssn;



        @FindBy(className="btn-secondary")
        public WebElement searchclick;

        // @FindBy(xpath="//*[@id=\"app-view-container\"]/div[1]/div/div/div/div[2]/div/form/div[1]/button")
        //public WebElement searchbutton;

        @FindBy(xpath = "//div[@class='Toastify__toast-body']")
        public WebElement toastContainer;

        @FindBy(name="firstName")
        public WebElement firstName;



    }


