package gmibank.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "/Users/ozgurcil/IdeaProjects/GMIBank23/src/test/resources/features",
        glue = "gmibank/step_defs",
        tags = "@CustomerDataTest",
        dryRun = false

)
public class OzgurRunner {
}
