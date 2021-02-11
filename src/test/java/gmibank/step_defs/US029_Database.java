package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojo.Customer;
import gmibank.utilities.DatabaseUtil;
import gmibank.utilities.TxtUtil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static gmibank.utilities.PDF_Generator.pdfGeneratorRowsAndCellsWithList;

public class US029_Database {

    List<Object> listOfIds;
    List<List<Object>> listAllData;
    String fileName = "src/test/resources/test_data1/customerID.txt";

    @Given("user connecting GMI database")
    public void user_connecting_GMI_database() {
        DatabaseUtil.createConnection();
    }

    @And("user read all  data from database {string}")
    public void userReadAllDataFromDatabase(String query) {
        DatabaseUtil.displayAllData(query);
    }

    @Given("user provides {string} and {string} nad gets column data")
    public void userProvidesAndNadGetsColumnData(String query, String columnName) {
     listOfIds = DatabaseUtil.getColumnData(query,columnName);
     TxtUtil.saveCustomerId(fileName,listOfIds);
    }

    @Then("user validate all column data")
    public void userValidateAllColumnData() {
        List<String> currentIds = new ArrayList<>();
        currentIds.add("50865");
        currentIds.add("61032");
        currentIds.add("36523");

       List<String> dbIds = TxtUtil.returnCustomerSSNList(fileName);
       Assert.assertTrue("The data from DB does not match: ",dbIds.containsAll(currentIds));
    }

    @Given("user provides {string} and {string} {string} {string} {string} nad gets column data")
    public void userProvidesAndNadGetsColumnData(String query, String firstName, String ssn, String state, String zipCode) {
      String header = "All Customer Info Project 3";
      String fileName= "src/test/resources/test_data1/customerlimitedInfo.pdf";

      List<Object> listOfNames =DatabaseUtil.getColumnData(query,firstName);
      List<Object> listOfSSN = DatabaseUtil.getColumnData(query,ssn);
      List<Object> listOfState = DatabaseUtil.getColumnData(query,state);
      List<Object> listOfZipCode = DatabaseUtil.getColumnData(query,zipCode);

      List<Customer> customers = new ArrayList<>();
      for (int i=0; i<5;i++){
          Customer customer=new Customer();
          customer.setFirstName(listOfNames.get(i).toString());
          customer.setSsn(listOfSSN.get(i).toString());
          customer.setSsn(listOfState.get(i).toString());
          customer.setZipCode(listOfZipCode.get(i).toString());
          customers.add(customer);
      }

        pdfGeneratorRowsAndCellsWithList(header,customers,fileName);
    }
    @And("user print all column data")
    public void userPrintAllColumnData() {
        
    }

    @And("user read all countries info from database {string}")
    public void userReadAllCountriesInfoFromDatabase(String query) {
    DatabaseUtil.executeQuery(query);
    DatabaseUtil.displayAllData(query);

//        Map<Integer, String> listMapCountry= new HashMap<>();
//        listMapCountry.put(22320,"South Korea");
//        listMapCountry.put(22335,"Sweden");
//        listMapCountry.put(24102,"France");

    }

    @Then("user validate all countries info")
    public void user_validate_all_countries_info() {

    }

    @Given("user read all states of related  to USA from database")
    public void user_read_all_states_of_related_to_USA_from_database() {
     // DatabaseUtil.executeQuery("select * from tp_state where tp_state.name='Virginia'");

    }

    @Then("user validate all states of  related to USA")
    public void user_validate_all_states_of_related_to_USA() {

    }
}
