package gmibank.step_defs;

import cucumber.api.java.en.*;
import org.testng.asserts.SoftAssert;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class US029_DatabaseSteps {

    String url = "jdbc:postgresql://157.230.48.97:5432/gmibank_db";
    String username="techprodb_user";
    String password="Techpro_@126";
    Connection connection; // Veritabanına bağlanmak için kullanacağız.
    Statement statement;   // Query'leri çalıştırmak ve verileri almak için kullanacağız.
    ResultSet resultSet;
    SoftAssert softAssert=new SoftAssert();
    List<String> userSsnNumber = new ArrayList<>();
    List<String> countryList = new ArrayList<>();
    List<String> statesList = new ArrayList<>();
    List<String> employeeNameList = new ArrayList<>();
    List<String> adminNameList = new ArrayList<>();

    @Given("user connects database")
    public void user_connects_database() throws Exception {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Given("user communicates with customer data and {string} asserts")
    public void user_communicates_with_customer_data_and_asserts(String string) throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM public.tp_customer");
        ResultSetMetaData userMetaData = resultSet.getMetaData();
        int columnCount = userMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(userMetaData.getColumnName(i));
        }
        while (resultSet.next()) {
            String ssn = resultSet.getString("ssn");
            userSsnNumber.add(ssn);
        }
        System.out.println(userSsnNumber);
        softAssert.assertTrue(userSsnNumber.contains(string));
    }
    @Given("user communicates admin data and asserts")
    public void user_communicates_admin_data_and_asserts() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM public.jhi_user");
        ResultSetMetaData userMetaData = resultSet.getMetaData();
        int columnCount = userMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(userMetaData.getColumnName(i));
        }
        while (resultSet.next()) {
            String adminname = resultSet.getString("first_name");
            adminNameList.add(adminname);
        }
        System.out.println(adminNameList);
        softAssert.assertTrue(adminNameList.contains("team20admin"));
    }
    @Given("user communicates employee and asserts")
    public void user_communicates_employee_and_asserts() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM public.jhi_user");
        ResultSetMetaData userMetaData = resultSet.getMetaData();
        int columnCount = userMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(userMetaData.getColumnName(i));
        }
        while (resultSet.next()) {
            String employeeName = resultSet.getString("first_name");
            employeeNameList.add(employeeName);
        }
        System.out.println(employeeNameList);
        softAssert.assertTrue(employeeNameList.contains("team20employee"));
    }
    @Given("user communicates with country data and asserts")
    public void user_communicates_with_country_data_and_asserts() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM public.tp_country");
        ResultSetMetaData userMetaData = resultSet.getMetaData();
        int columnCount = userMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(userMetaData.getColumnName(i));
        }
        while (resultSet.next()) {
            String countryName = resultSet.getString("name");
            countryList.add(countryName);
        }
        System.out.println(countryList);
        softAssert.assertTrue(countryList.contains("Japan"));
    }
    @Given("user communicates with  state data and asserts")
    public void user_communicates_with_state_data_and_asserts() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM public.tp_state "); //WHERE name  = 'Washington'
        ResultSetMetaData statesMetaData = resultSet.getMetaData();
        int columnCount = statesMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(statesMetaData.getColumnName(i));
        }
        while (resultSet.next()) {
            String states = resultSet.getString("id");
            statesList.add(states);
        }
        System.out.println(statesList);
    }
}