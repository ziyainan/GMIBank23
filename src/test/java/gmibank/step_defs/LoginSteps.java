package gmibank.step_defs;

import cucumber.api.java.en.*;
import gmibank.pages.GmiPage;
import gmibank.utilities.Driver;


public class LoginSteps {

    GmiPage gmiPage = new GmiPage();
    static String url= "https://gmibank.com/";
    @Given("I as a user navigate to GMI bank webPage")
    public void i_as_a_user_navigate_to_GMI_bank_webPage() {
        Driver.getDriver().get(url);
    }

    @Given("I as a user click to login sign")
    public void i_as_a_user_click_to_login_sign() {
        gmiPage.usericon.click();
    }

    @And("I as a user choose sign from dropdown menu")
    public void i_as_a_user_choose_register_from_dropdown_menu() {
        gmiPage.signin.click();
    }

    @When("I as a user enter my UserName and Password in to opened frame")
    public void i_as_a_user_enter_my_UserName_and_Password_in_to_opened_frame()  {
        gmiPage.userName.sendKeys("lindapine");
        gmiPage.password.sendKeys("12345Linda");
    }

    @Then("I click sign in button and sign in")
    public void i_click_sign_in_button_and_sign_in() {  gmiPage.signin2.click();     }

    @Then("I click to My Operation button")
    public void i_click_to_My_Operation_button() { gmiPage.MyOperations.click();
    }

    @Then("I click to Manage Customers link")
    public void i_click_to_Manage_Customers_link() {gmiPage.ManCustomer.click();
    }

   @Then("I Click on Create a new Customer buttun to navigate Create Customer page")
    public void i_Click_on_Create_a_new_Customer_buttun_to_navigate_Create_Customer_page() {
    gmiPage.createUser.click();
    }

 //   @Then("I Enter a Valid SSN number")
//    public void i_Enter_a_Valid_SSN_number() { gmiPage.ssnAlert.sendKeys("234-43-4565");
  //  }

    @Then("I Enter a valid First Name")
    public void i_Enter_a_valid_First_Name() {gmiPage.firstName.sendKeys("AKa");

    }

    @Then("I Enter a valid last name")
    public void i_Enter_a_valid_last_name() {gmiPage.lastName.sendKeys("Sema");

    }
    @Then("I Enter a valid middle name")
    public void i_Enter_a_valid_middle_name() {gmiPage.middleName.sendKeys("AS");

    }

    @Then("I Enter a valid email")
    public void i_Enter_a_valid_email() {gmiPage.email.sendKeys("aka1@gmail.com");

    }

    @Then("I Enter a valid mobile phone number")
    public void i_Enter_a_valid_mobile_phone_number() {gmiPage.mobilePhone.sendKeys("571-234-2345");

    }

    @Then("I Enter a valid phone number")
    public void i_Enter_a_valid_phone_number() {gmiPage.phoneNumber.sendKeys("212-342-5678");

    }

    @Then("I Enter a valid Zip Code")
    public void i_Enter_a_valid_Zip_Code() {gmiPage.zipCode.sendKeys("22033");

    }

    @Then("I Enter a valid Adress including a Street Number")
    public void i_Enter_a_valid_Adress_including_a_Street_Number() {gmiPage.adress.sendKeys("1234 Lee Highway");

    }
    @Then("I Enter a valid City name")
    public void i_Enter_a_valid_City_name() {gmiPage.cityName.sendKeys("Fairfax");

    }

    @Then("I Enter a valid SSN number")
    public void i_Enter_a_valid_SSN_number() {gmiPage.ssnBox.sendKeys("234-54-8645");

    }

    @Then("I Enter a valid State name")
    public void i_Enter_a_valid_State_name() {gmiPage.stateName.sendKeys("Virginia");

    }

    @Then("I Enter a valid Country name")

    public void i_Enter_a_valid_Country_name() {
        gmiPage.countryName.sendKeys("USA");
        gmiPage.userType.sendKeys("AKA");
        gmiPage.custAccount.click();


    }

    @Then("I clisk Save Button")
    public void i_clisk_Save_Button() {gmiPage.bttnSave.click();

    }



}
