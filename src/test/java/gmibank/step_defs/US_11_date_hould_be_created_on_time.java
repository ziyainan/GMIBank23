package gmibank.step_defs;

import cucumber.api.java.en.Then;
import gmibank.pages.US_11_Creation_Customer;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.Driver;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class US_11_date_hould_be_created_on_time {
US_11_Creation_Customer creation_customer=new US_11_Creation_Customer();
    @Then("enter valid username {string}")
    public void enter_valid_username(String string) {
        creation_customer.userName.sendKeys(string);
    }

    @Then("enter valid password {string}")
    public void enter_valid_password(String string) {
        creation_customer.password.sendKeys(string);
    }


    @Then("click sign in button")
    public void click_sign_in_button() {
        creation_customer.signInButton.click();
    }

    @Then("click my operations blog")
    public void click_my_operations_blog() {
      creation_customer.myoperationButton.click();
    }

    @Then("click manage customers")
    public void click_manage_customers() {
       creation_customer.manageCustomer.click();
    }

    @Then("click create a new customer")
    public void click_create_a_new_customer() {
creation_customer.cnewCustomer.click();
    }


    @Then("enter firstname{string}")
    public void enter_firstname(String string) {
creation_customer.cfirstname.sendKeys(string);
    }

    @Then("enter lastname{string}")
    public void enter_lastname(String string) {
       creation_customer.clastname.sendKeys(string);
    }

    @Then("enter middle{string}")
    public void enter_middle(String string) {
    creation_customer.cmiddle.sendKeys(string);
    }

    @Then("enter email{string}")
    public void enter_email(String string) {
        creation_customer.cemail.sendKeys(string);
    }

    @Then("enter mobil phone{string}")
    public void enter_mobil_phone(String string) {
       creation_customer.cmobilPhone.sendKeys(string);
    }

    @Then("enter phone{string}")
    public void enter_phone(String string) {
        creation_customer.cphone.sendKeys(string);
    }

    @Then("enter zip code{string}")
    public void enter_zip_code(String string) {
      creation_customer.czip.sendKeys(string);
    }

    @Then("enter address{string}")
    public void enter_address(String string) {
       creation_customer.caddress.sendKeys(string);
    }

    @Then("enter city{string}")
    public void enter_city(String string) {
        creation_customer.ccity.sendKeys(string);
    }

    @Then("enter ssn again{string}")
    public void enter_ssn_again(String string) {
      creation_customer.cssn2.sendKeys(string);
    }



    @Then("Create earlier {string}")
    public void create_earlier(String string) {
        creation_customer.cndate.sendKeys(string);
    }

    @Then("enter country")
    public void enter_country() {
        Select option=new Select(creation_customer.ccountry);
        option.selectByIndex(2);
    }

    @Then("enter state{string}")
    public void enter_state(String string) {
creation_customer.cstate.sendKeys(string);
    }

    @Then("choose user")
    public void choose_user() {
      Select option2=new Select(creation_customer.cuser);
      option2.selectByIndex(0);

    }

    @Then("choose account")
    public void choose_account() {
        Select option3=new Select(creation_customer.caccount);
        option3.selectByIndex(2);
    }

    @Then("select zelle enrolled")
    public void select_zelle_enrolled() {
       creation_customer.czelle.click();
    }

    @Then("and saved")
    public void and_saved() {
       creation_customer.csaveButton.click();
    }

    @Then("verify save button is displayed")
    public void verify_save_button_is_displayed() {
Driver.wait(3);
Assert.assertTrue(creation_customer.csaveButton.isDisplayed());
   // Assert.assertTrue(creation_customer.cnewCustomer.isDisplayed());
    }

    @Then("verify cancel button is displayed")
    public void verify_cancel_button_is_displayed() {
        Driver.wait(3);
       Assert.assertTrue(creation_customer.cback.isDisplayed());
    }

    @Then("enter date {string}")
    public void enter_date(String date) {
       creation_customer.cndate.sendKeys(date);

    }

    @Then("enter date of today")
    public void enter_date_of_today() {
        Date today=new Date();
        String today1=today.toString();
        creation_customer.cndate.sendKeys(today1);

    }


    @Then("verify date is match as month,day, year and minute")
    public void verify_date_is_match_as_month_day_year_and_minute() {

Date today=new Date();
//        SimpleDateFormat date=new SimpleDateFormat("MMM-dd-yyyy HH:mm");
//String expected=date.format(today);
//String expected1="YYYY-MM-DD HH:mm";

//String actual1=creation_customer.cndate.getText();
     String actual =creation_customer.cndate.getAttribute("placeholder");
String expected="YYYY-MM-DD HH:mm";
     Assert.assertEquals(expected,actual);

    }


    @Then("choose user as a blank")
    public void choose_user_as_a_blank() {
        Select option2=new Select(creation_customer.cuser);
        option2.selectByIndex(0);
    }


    @Then("verify home page link is displayed")
    public void verify_home_page_link_is_displayed() {
        Driver.wait(2);
        Assert.assertTrue(creation_customer.homelink.isDisplayed());
    }

    @Then("verify zelle enrolled selected")
    public void verify_zelle_enrolled_selected() {
        Driver.wait(2);
     String zelle=   creation_customer.czelle.getAttribute("value");
       Assert.assertEquals(zelle,"true");
    }

    @Then("verify create a custmoer button is displayed")
    public void verify_create_a_custmoer_button_is_displayed() {
Assert.assertTrue(creation_customer.cnewCustomer.isDisplayed());
    }
}
