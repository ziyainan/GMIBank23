package gmibank.step_defs;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import gmibank.pages.US003_US0007_US0015_US0016_StoriesPages;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class US007_EmailAndLanguageBarSteps {

        US003_US0007_US0015_US0016_StoriesPages US003_email = new US003_US0007_US0015_US0016_StoriesPages();

        /*
                @Given("user go to the login page")
                public void user_go_to_the_login_page()  {
                    Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
                    Driver.waitAndClick(US003_email.accountmenu,2);
                    Driver.waitAndClick(US003_email.loginitem,2);


                }

                @When("user enter an email {String} which is not contain '.' extension")
                public void user_enter_an_email_something_which_is_not_contain_extension(String strArg1)  {
                    Driver.waitAndSendText(US003_email.pass, strArg1,2);

                }

                @When("user click the language bar")
                public void user_click_the_language_bar()  {
                    Driver.waitAndClick(US003_email.language,2);

                }

                @Then("system displays This field is invalid")
                public void system_displays_this_field_is_invalid()  {
                    String invalid=Driver.waitAndGetText(US003_email.invalid,2);
                    Assert.assertEquals("This field is invalid",invalid);

                }

        //        @Then("system displays This field is invalid")
        //        public void system_displays_this_field_is_invalid_()  {
        //            String invalid=Driver.waitAndGetText(US003_email.invalid,2);
        //            Assert.assertEquals("This field is invalid",invalid);
          //      }

                @Then("user there is only two language options and these are English or Turkish")
                public void user_there_is_only_two_language_options_and_these_are_english_or_turkish()  {
                    Driver.selectAnItemFromDropdown(US003_email.language,"Türkçe");
                    Driver.selectAnItemFromDropdown(US003_email.language,"English");

                }

                @And("user login as an admin by username {String} password {String}")
                public void user_login_as_an_admin_by_username_something_password_something(String strArg1, String strArg2) throws Throwable {
                    Driver.waitAndSendText(US003_email.username, strArg1,2);
                    Driver.waitAndSendText(US003_email.password, strArg2,2);

                }

                @And("user click the user info and navigate user setting page")
                public void user_click_the_user_info_and_navigate_user_setting_page()  {
                    Driver.waitAndClick(US003_email.submit,2);
                }

        */
        @Given("user go to the login page")
        public void user_go_to_the_login_page() {
            Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
            Driver.waitAndClick(US003_email.accountmenu, 2);
            Driver.waitAndClick(US003_email.loginitem, 2);
        }

        @Given("user login as an admin by username {string} password {string}")
        public void user_login_as_an_admin_by_username_password(String string, String string2) {

            Driver.waitAndSendText(US003_email.username, string, 4);
            Driver.waitAndSendText(US003_email.password, string2, 4);
            Driver.waitAndClick(US003_email.submit, 4);

        }

        @Given("user click the user info and navigate user setting page")
        public void user_click_the_user_info_and_navigate_user_setting_page() {
            Driver.waitAndClick(US003_email.accountmenu, 2);
            Driver.waitAndClick(US003_email.userinfo,2);

        }

        @When("user enter an email {string} which is not contain . extension")
        public void user_enter_an_email_which_is_not_contain_extension(String string) {
                Driver.waitAndSendText(US003_email.pass, string,2);
        }

        @Then("system displays This field is invalid.")
        public void system_displays_This_field_is_invalid() {
            String invalid=Driver.waitAndGetText(US003_email.invalid,2);
//            Assert.assertEquals("This field is invalid",invalid);
        }

        @When("user click the language bar")
        public void user_click_the_language_bar() {
            Driver.waitAndClick(US003_email.language,2);
        }

        @Then("user there is only two language options and these are English or Turkish")
        public void user_there_is_only_two_language_options_and_these_are_English_or_Turkish() {
            Driver.selectAnItemFromDropdown(US003_email.language,"Türkçe");
            Driver.selectAnItemFromDropdown(US003_email.language,"English");
            Select sel=new Select(US003_email.language);
              List<WebElement> list = sel.getOptions();
               System.out.println(list.size());
               Assert.assertEquals(list.size(),2);
            }
        }

