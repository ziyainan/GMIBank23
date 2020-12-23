package gmibank.runners;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features/us010_tc.feature",
        glue = "gmibank/stepdefinitions",
        tags = "@us001tc010",
        dryRun = false
)
public class Kadir_Runner {

}
