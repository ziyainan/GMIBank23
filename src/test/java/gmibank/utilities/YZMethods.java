package gmibank.utilities;

import gmibank.pages.US013_EmployeeCreateNewAccountPage;
import org.openqa.selenium.support.ui.Select;

public class YZMethods {

    public static US013_EmployeeCreateNewAccountPage locators = new US013_EmployeeCreateNewAccountPage();

    public static void employeeLogIn () {
        Driver.waitAndClick(locators.accountMenu, 1);
        Driver.waitAndClick(locators.signIn, 1);
        Driver.waitAndSendText(locators.userName, ConfigurationReader.getProperty("userName"), 1);
        Driver.waitAndSendText(locators.password, ConfigurationReader.getProperty("password"), 1);
        Driver.waitAndClick(locators.signInButton, 1);
    }

    public static void fillExceptDescription () {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
        Driver.selectAnItemFromDropdown(locators.accountType,ConfigurationReader.getProperty("accountType"));
        Driver.selectAnItemFromDropdown(locators.accountStatusType,ConfigurationReader.getProperty("accountStatus"));
    }

    public static void fillExceptBalance () {
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
        Driver.selectAnItemFromDropdown(locators.accountType,ConfigurationReader.getProperty("accountType"));
        Driver.selectAnItemFromDropdown(locators.accountStatusType,ConfigurationReader.getProperty("accountStatus"));
    }

    public static void fillExceptAccountType () {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
        Driver.selectAnItemFromDropdown(locators.accountStatusType,ConfigurationReader.getProperty("accountStatus"));
    }

    public static void fillExceptAccountStatusType () {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
        Driver.selectAnItemFromDropdown(locators.accountType,ConfigurationReader.getProperty("accountType"));
    }

    public static void fillExceptEmployee () {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
        Driver.selectAnItemFromDropdown(locators.accountType,ConfigurationReader.getProperty("accountType"));
        Driver.selectAnItemFromDropdown(locators.accountStatusType,ConfigurationReader.getProperty("accountStatus"));
    }

}

