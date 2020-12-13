package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US017_AdminManageUserPage;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;

public class US017_AdminManageUserSteps {

    US017_AdminManageUserPage us017_adminManageUserPage=new US017_AdminManageUserPage();

    @Given("user signs in as an admin {string} and {string}")
    public void user_signs_in_as_an_admin_and(String username, String password) {
        Driver.waitAndClick(us017_adminManageUserPage.arrow,2);
        Driver.waitAndClick(us017_adminManageUserPage.dropdownSignIn);
        Driver.waitAndSendText(us017_adminManageUserPage.username, ConfigurationReader.getProperty("admin_username"),2);
        Driver.waitAndSendText(us017_adminManageUserPage.password, ConfigurationReader.getProperty("admin_password"),2);
        Driver.waitAndClick(us017_adminManageUserPage.SignIn,2);
    }

    @Given("user goes to Administration module and goes to User management segment")
    public void user_goes_to_Administration_module_and_goes_to_User_management_segment() {
        Driver.waitAndClick(us017_adminManageUserPage.administration,2);
        Driver.waitAndClick(us017_adminManageUserPage.userManagement,2);
    }

    @Given("admin activates the role as user with login name pixie")
    public void admin_activates_the_role_as_user_with_login_name_pixie() {
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pageTwo);
        Driver.waitAndClick(us017_adminManageUserPage.pixieUser,2);
        //Assert.assertEquals(us017_adminManageUserPage.userConfirmation.getText(),"A user is updated with identifier pixie_user");
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pageTwo);
        Driver.waitAndClick(us017_adminManageUserPage.pixieUser,2);
    }

    @Given("admin activates the role as employee with login name pixie_employee")
    public void admin_activates_the_role_as_employee_with_login_name_pixie_employee() {
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pageTwo);
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pixieEmployee);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pixieEmployee);

    }

    @Given("admin activates the role as manager with login name pixie_manager")
    public void admin_activates_the_role_as_manager_with_login_name_pixie_manager() {
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pixieManager);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pixieManager);
    }

    @Given("admin activates the role as admin with login name pixie_admin")
    public void admin_activates_the_role_as_admin_with_login_name_pixie_admin() {
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pageTwo);
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pixieAdmin);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pageTwo);
        BrowserUtils.clickWithJS(us017_adminManageUserPage.pixieAdmin);
    }

    @Then("admin clicks on View button and verify all user info")
    public void admin_clicks_on_View_button_and_verify_all_user_info() {
        BrowserUtils.clickWithJS(us017_adminManageUserPage.viewButton);
        BrowserUtils.verifyElementDisplayed(us017_adminManageUserPage.roleManager);
    }

    @Then("admin clicks on Edit button and edit all user info")
    public void admin_clicks_on_Edit_button_and_edit_all_user_info() {
        BrowserUtils.clickWithJS(us017_adminManageUserPage.editButton);
        Driver.waitAndSendText(us017_adminManageUserPage.firstnameBox,"PixieUpdated");
        Driver.waitAndClick(us017_adminManageUserPage.saveButton);

    }

    @Then("admin clicks on Delete button and delete all user info")
    public void admin_clicks_on_Delete_button_and_delete_all_user_info() throws InterruptedException {
        Driver.waitAndClick(us017_adminManageUserPage.deleteButton);
        Thread.sleep(2000);
        Assert.assertTrue(us017_adminManageUserPage.deleteMessage.isDisplayed());
    }
}
