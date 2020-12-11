package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US008_UserPasswordUpdatePage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US008_UserPasswordUpdate {


    US008_UserPasswordUpdatePage us008Update = new US008_UserPasswordUpdatePage();

    @Given("User Go to Home Page")
    public void user_Go_to_Home_Page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Then("User click Sign in button")
    public void user_click_Sign_in_button() {
        us008Update.signInMenu.click();
        us008Update.signInLink.click();
    }

    @Then("User enter Username and Password")
    public void user_enter_Username_and_Password() {
        us008Update.usernameTextbox.sendKeys("taci");
        us008Update.passwordTextbox.sendKeys("Starteam23/");
    }

    @Then("User click Sign in Box")
    public void user_click_Sign_in_Box() {
        us008Update.signInButton.click();
    }

    @Then("User click password")
    public void user_click_password() {
        Driver.waitAndClick(us008Update.taciKorkmazLink, 2);
        Driver.waitAndClick(us008Update.passwordSegment, 2);
    }

    @Then("User enter Current password")
    public void user_enter_Current_password() {
        us008Update.currentPassword.sendKeys("Starteam23/");
    }

    @Given("Enter the password {string}")
    public void enter_the_password(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter new password like the same old password {string}")
    public void enter_new_password_like_the_same_old_password(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Then("Check the new password different than old one")
    public void check_the_new_password_different_than_old_one() {
        String expected = us008Update.newPasswordText.getAttribute("value");
        String actual = us008Update.currentPasswordText.getAttribute("value");
        Assert.assertNotEquals(actual, expected);
    }

    @Given("Enter the new password diffent then old one {string}")
    public void enter_the_new_password_diffent_then_old_one(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Then("Compare the new pasword is diffrent than old one")
    public void compare_the_new_pasword_is_diffrent_than_old_one() {
        String expected = us008Update.newPasswordText.getAttribute("value");
        String actual = us008Update.currentPasswordText.getAttribute("value");
        Assert.assertNotEquals(actual, expected);
    }

    @Given("Enter the new password with at least one lowercase {string}")
    public void enter_the_new_password_with_at_least_one_lowercase(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Then("User see full password strength")
    public void user_see_full_password_strength() {
        Assert.assertTrue(us008Update.passwordStrengthfive.isEnabled());
    }

    @Given("Enter the new password without lowercase {string}")
    public void enter_the_new_password_without_lowercase(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Then("User not see full password strength")
    public void user_not_see_full_password_strength() {
        Assert.assertTrue(us008Update.passwordStrengthFour.isEnabled());
    }

    @Given("Enter the new password with at least one uppercase {string}")
    public void enter_the_new_password_with_at_least_one_uppercase(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password without uppercase {string}")
    public void enter_the_new_password_without_uppercase(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password with at least one digit {string}")
    public void enter_the_new_password_with_at_least_one_digit(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password without digit {string}")
    public void enter_the_new_password_without_digit(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password with at least one special chracter {string}")
    public void enter_the_new_password_with_at_least_one_special_chracter(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password without special character {string}")
    public void enter_the_new_password_without_special_character(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password with at least seven character {string}")
    public void enter_the_new_password_with_at_least_seven_character(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password with less than seven character {string}")
    public void enter_the_new_password_with_less_than_seven_character(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Given("Enter the new password {string}")
    public void enter_the_new_password(String string) {
        us008Update.newPassword.sendKeys(string);
    }

    @Then("Enter the confirm password {string}")
    public void enter_the_confirm_password(String string) {
       us008Update.confirmPassword.sendKeys(string);
    }

    @Then("Compare the new and confirm password are same")
    public void compare_the_new_and_confirm_password_are_same() {
        String actual = us008Update.newPasswordText.getAttribute("value");
        String expected = us008Update.confirmPasswordText.getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Then("Enter the confirm password whic diffrent than new password {string}")
    public void enter_the_confirm_password_whic_diffrent_than_new_password(String string) {
        us008Update.confirmPassword.sendKeys(string);
    }

    @Then("Check the error message")
    public void check_the_error_message() {
//        System.out.println(Driver.waitAndGetText(us008Update.confirmPasswordErrorMessage));
//        Driver.waitAndClick(us008Update.confirmPasswordErrorMessage);
        us008Update.confirmPasswordText.sendKeys(Keys.ENTER);
        Assert.assertTrue(us008Update.confirmPasswordErrorMessage.isDisplayed());
    }
}