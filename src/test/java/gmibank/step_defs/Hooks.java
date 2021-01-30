package gmibank.step_defs;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private final static Logger logger = Logger.getLogger(Hooks.class);


    @Before
    public void setUp() {
        logger.info("::: Starting automation :::");
        logger.info("Browser type: " + ConfigurationReader.getProperty("browser"));
        logger.info("URL: " + ConfigurationReader.getProperty("login_url"));

////    public void setUp(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("login_url"));
    }

    @After
    public void tearDown(Scenario scenario) {

         logger.info("Taking a screenshot");

        //if (scenario.isFailed()){


        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");

        // Driver.getDriver().close();  \
        Driver.closeDriver();
    }

    

}
