package gmibank.step_defs;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US018.US018_AllowAdminToManageCostumerPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;
import java.util.List;

public class US018_AllowAdminToManageCostumerStep {

    static Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();
    US018_AllowAdminToManageCostumerPage allowAdminToManageCostumerPage = new US018_AllowAdminToManageCostumerPage();

    @Given("Go to Main Web Page of GMI BANK {string}")
    public void go_to_Main_Web_Page_of_GMI_BANK(String string) {

        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Given("admin should click on the man icon first")
    public void admin_should_click_on_the_man_icon_first() {

        allowAdminToManageCostumerPage.manIcon.click();
    }

    @Given("then admin should click on sign in to log in to Gmi Bank")
    public void then_admin_should_click_on_sign_in_to_log_in_to_Gmi_Bank() {

        allowAdminToManageCostumerPage.signIn.click();
    }

    @Given("fill in the user-name and password as a admin")
    public void fill_in_the_user_name_and_password_as_a_admin() {

        Driver.waitAndSendText(allowAdminToManageCostumerPage.userNameBox,ConfigurationReader.getProperty("admin_username"),2);
        Driver.waitAndSendText(allowAdminToManageCostumerPage.passwordBox,ConfigurationReader.getProperty("admin_password"),2);
        Driver.waitAndClick(allowAdminToManageCostumerPage.signInButton);

    }

    @Given("admin should be able to log into main page using admin, to click on administration")
    public void admin_should_be_able_to_log_into_main_page_using_admin_to_click_on_administration() {

        Driver.waitAndClick(allowAdminToManageCostumerPage.administrationDropDown);

    }

    @Given("then admin should click user-management to open up all the costumers info")
    public void then_admin_should_click_user_management_to_open_up_all_the_costumers_info() {

        allowAdminToManageCostumerPage.userManagement.click();



    }

    @Then("There should be a View option where admin can be navigated to all customer info and see \\(edit button\\/This is a bug) there")
    public void there_should_be_a_View_option_where_admin_can_be_navigated_to_all_customer_info_and_see_edit_button_This_is_a_bug_there() {

        allowAdminToManageCostumerPage.viewButton.click();
        String str = "";
        List<WebElement> elements = Driver.getDriver().findElements(By.id("root"));

        for(WebElement w: elements){
             str = w.getText();
            System.out.println(str);
        }
        //softAssert.assertTrue(str.contains("Edit"));

        Driver.getDriver().navigate().back();
        Driver.wait(2);

    }

    @Then("There should be an Edit button where all customer information can be populated")
    public void there_should_be_an_Edit_button_where_all_customer_information_can_be_populated() {

        allowAdminToManageCostumerPage.editButton.click();

    }

    @Then("Edit portal can allow user to create or update the user info")
    public void edit_portal_can_allow_user_to_create_or_update_the_user_info() throws InterruptedException {

        allowAdminToManageCostumerPage.nameBox.clear();
        allowAdminToManageCostumerPage.nameBox.sendKeys(faker.name().firstName());
        allowAdminToManageCostumerPage.editAButton.click();
        Thread.sleep(2000);
        System.out.println(allowAdminToManageCostumerPage.toastAnimation.getText());
        Assert.assertTrue(allowAdminToManageCostumerPage.toastAnimation.getText().contains("A user is updated"));
        Driver.wait(5);
    }

    @Then("admin can delete a customer, but seeing a message if the user is sure about deletion")
    public void admin_can_delete_a_customer_but_seeing_a_message_if_the_user_is_sure_about_deletion() {

       allowAdminToManageCostumerPage.deleteButton.click();


    }

}
