package gmibank.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports",
				"json:target/cucumber.json",
				"html:target/cucumber.html",
				"junit:target/xml-report/cucumber.xml"
		},
		features = "src/test/resources/features",
		glue = "gmibank/step_defs",
		tags = "@US004_TC001",
		dryRun = false
)

public class Runner {

}

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		plugin = {"html:target/cucumber-report.html" ,
//				"json:target/cucumber.json" ,
//				"rerun:target/rerun.txt"
//		},
//		features = "src/test/resources/features" ,
//		glue = "com/bitrix24/stepdefinitions",
//		dryRun = false,
//		tags = "@login",
//		publish = true
//)