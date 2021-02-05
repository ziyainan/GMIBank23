package gmibank.pages;

import gmibank.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    Logger logger = Logger.getLogger(BasePage.class);

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Tuncay
    public void getPageTitle() {
        System.out.println("Page title is: "+Driver.getDriver().getTitle());
    }

//    public static void waitForPageToLoad(long timeOutInSeconds) {
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//            }
//        };
//        try {
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
//            wait.until(expectation);
//        } catch (Exception error) {
//            error.printStackTrace();
//        }
  //
 //   }

}
