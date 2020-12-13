package gmibank.utilities;

import gmibank.pages.US014_DateCreationOfAccountPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ZiyaMethods {
    US014_DateCreationOfAccountPage US014= new US014_DateCreationOfAccountPage();

//    public static void executeJScommand(WebElement element, String command) {
//        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//        jse.executeScript(command, element);
//    }

    public static void JSuntillButton() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void JSfindElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", element);
    }





}
