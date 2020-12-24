package gmibank.runners;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features/US023_Read_All_Aplicants.feature",
        glue = "gmibank/step_defs",
        tags = "@AllCustomerData",
        dryRun = false)
public class Kadir_Runner {

}
