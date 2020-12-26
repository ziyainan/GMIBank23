package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.testng.Assert;
import gmibank.pages.US003_US0007_US0015_US0016_StoriesPages;

public class US003_PasswordStrengthSteps {

    US003_US0007_US0015_US0016_StoriesPages US003_Password=new US003_US0007_US0015_US0016_StoriesPages();

    @Given("user go to registration")
    public void user_go_to_registration() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        Driver.waitAndClick(US003_Password.loginDropdown,2);
        Driver.waitAndClick(US003_Password.register,2);
}

    @When("user provides password {string}")
        public void user_provides_password(String string) throws InterruptedException {
        Driver.waitAndSendText(US003_Password.pass,string,3);
        Thread.sleep(2000);

    }

    @Then("user see the level  chart change accordingly")
        public void user_see_the_level_chart_change_accordingly() {
        String style=US003_Password.strengthbar.getAttribute("style").toString();
        Assert.assertEquals(style,"background-color: rgb(255, 153, 0);");
    }

    @Then("user can't see the level  chart change accordingly")
        public void user_can_t_see_the_level_chart_change_accordingly() {
        String style=US003_Password.strengthbar.getAttribute("style").toString();
        Assert.assertEquals(style,"background-color: rgb(221, 221, 221);");
    }

    @When("user provides least {int} chars for a stronger password {string}")
        public void user_provides_least_chars_for_a_stronger_password(Integer int1, String string) {
       Driver.waitAndSendText(US003_Password.pass,string,4);
    }

    @Then("user see the stronger password")
    public void user_see_the_stronger_password() {
        String style=US003_Password.strengthbar1.getAttribute("style").toString();
        Assert.assertEquals(style,"background-color: rgb(0, 255, 0);");
    }

    @When("user provides less than {int} chars for a stronger password {string}")
        public void user_provides_less_than_chars_for_a_stronger_password(Integer int1, String string) {
        Driver.waitAndSendText(US003_Password.pass,string,4);

    }

    @Then("user can not see the stronger password")
    public void user_can_not_see_the_stronger_password() {
        String style=US003_Password.strengthbar1.getAttribute("style").toString();
        Assert.assertEquals(style,"background-color: rgb(221, 221, 221);");
    }

}
