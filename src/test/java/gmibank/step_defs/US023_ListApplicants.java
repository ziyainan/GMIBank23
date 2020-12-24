package gmibank.step_defs;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.itextpdf.text.*;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfWriter;
import cucumber.api.java.en.*;
import gmibank.pojos;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadTxt;
import gmibank.utilities.WriteToTxt;
import groovyjarjarpicocli.CommandLine;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import static io.restassured.RestAssured.given;

public class US023_ListApplicants {
static String url="https://www.gmibank.com/api/tp-account-registrations";
  static String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWFtMTFhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTYwODgzODg3Nn0.sZmxVrKB6QpbX81HNxW8ZyGZ209pbklz3ffnM8EVNPlwLPOsOu_1xvs7JsdDYkvuDJlHukELKnJMp-A09UVuig";
    static RequestSpecification request;
  static Response response;
    static pojos.Customer[] customers;
    @Given("user provides the api end point to set the response using {string}")
    public void user_provides_the_api_end_point_to_set_the_response_using(String string)  {
        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty("api_url"))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        // response.prettyPrint();
        System.out.println(" **** Connected to API and Respond Received Successfully ***");
    }
    @Given("manuplate all customer`s data")
    public void manuplate_all_customer_s_data() throws Exception{
        ObjectMapper obj =new ObjectMapper() ;
        customers= obj.readValue(response.asString(), pojos.Customer[].class);
           for (int i=0; i< customers.length;i++)
          System.out.println(customers[i].getFirstName()+" "+customers[i].getLastName()+" "+customers[i].getSsn());


    }
        @Given("user sets the data in correspondent files")
        public void user_sets_the_data_in_correspondent_files() throws Exception {

            WriteToTxt.saveDataInFileWithAllCustomerInfo("AllCustomerData.txt",customers);
            System.out.println("DATA Writing Finished successfully");
        }
    @Then("user validate all data")
    public void user_validate_all_data() throws Exception {
        List<pojos.Customer> list = ReadTxt.readTxtData("SSNData.txt");
     /*   for (int i=0; i< list.size();i++){
            // System.out.println(list.get(i).getSsn());
            String newSSN=list.get(i).getSsn();
            // if (newSSN=="789-45-6123") {
            if (newSSN.contains("6123")){
                System.out.println("We Validate SSN");
            }else {
                System.out.println("We couldnt validate SSN");}
        }
*/
    }

    @Then("as a user i want to print All userName  as a pdf file")
    public void as_a_user_i_want_to_print_All_userName_as_a_pdf_file() throws FileNotFoundException, DocumentException {
        List<pojos.Customer> userList = ReadTxt.returnCustomer("AllCustomerData1.txt");
        Document document = new Document();
        for (int i=0; i< 10;i++) {
            String firstName=customers[i].getFirstName();
            String newlastName=customers[i].getLastName();
            System.out.println(firstName+" "+newlastName);
            //  String newSSN=userList.get(i).getSsn();
            //  System.out.println(customers[i].getFirstName()+" "+customers[i].getLastName()+" "+customers[i].getSsn());

            PdfWriter.getInstance(document, new FileOutputStream("UserNames1.pdf"));

            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

            Chunk chunk = new Chunk(firstName, font);
            document.add(chunk);
            Chunk chunk1=new Chunk(newlastName, font);
            document.add(chunk1);
            // Chunk chunk2=new Chunk(newSSN, font);
            // document.add(chunk2);



        }
        document.close();
    }

}