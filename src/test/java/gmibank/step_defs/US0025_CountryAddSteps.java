package gmibank.step_defs;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import gmibank.utilities.ConfigurationReader;
//import gmibank.utilities.apiUtils;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import static org.hamcrest.Matchers.*;
//import static io.restassured.RestAssured.*;
//
//
//
//
//
//public class US0025_CountryAddSteps {
//
//    @Given("I perform GET operation for end_point {string}")
//    public void i_perform_GET_operation_for_end_point(String string) {
//      request.put("")
//    }
//
//    @Then("I should see all the countries")
//    public void i_should_see_all_the_countries() {
//
//    }
//
//    @Given("I perform POST operation for end_point {string}")
//    public void i_perform_POST_operation_for_end_point(String string) {
//
//    }
//
//    @Then("I should get success added message")
//    public void i_should_get_success_added_message() {
//
//    }
//
//
//
//
//}
//import com.team23.utilities.ConfigurationReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.jsonModels.CountryJson;
import gmibank.pojos.Country;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadTxt;
import gmibank.utilities.WriteToTxt;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.given;


public class US0025_CountryAddSteps {
    Response response;
    Country[] country;
    @Given("user provide the API endpoint response {string}")
    public void user_provide_the_API_endpoint_response(String endpoint) {
        response=given().headers(
                "Authorization",
                "Bearer "+ ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
       // response.prettyPrint();
    }
    @Given("user create a new country by endpoint {string}  {string}")
    public void user_create_a_new_country_by_endpoint(String endpoint, String countryname) {
        response=given().headers(
                "Authorization",
                "Bearer "+ ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body(CountryJson.createCountry1)
                .post(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        System.out.println("status code:"+response.statusCode());
        Assert.assertEquals(201,response.statusCode());
    }

    @Given("user deserialize to java")
    public void user_deserialize_to_java() throws IOException {
        ObjectMapper obj=new ObjectMapper();
        country=obj.readValue(response.asString(),Country[].class);
         //    for(int i=0; i<country.length; i++){
         //  System.out.println(country[i].getName());
           //Assert.assertTrue(country[i].getName().contains("Tajikistan"));

     //   }

    }

    @Given("user add all data corresponding file")
    public void user_add_all_data_corresponding_file() {
        WriteToTxt.saveAllCountries("src/test/resources/TestData/Countries.txt", country);
    }

    @Then("user validate the country successfully created")
    public void user_validate_the_country_successfully_created() {
        List<String> expectedcountry=new ArrayList<>();
        expectedcountry.add("asim");
        List<Country> allcountries=ReadTxt.returnAllCountries("src/test/resources/TestData/Countries.txt");
        Assert.assertTrue("all do not match",expectedcountry.containsAll(allcountries));
        System.out.println("All validations has been succesfull");
    }

}
