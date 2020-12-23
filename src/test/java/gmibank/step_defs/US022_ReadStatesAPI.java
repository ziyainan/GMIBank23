package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.*;
import gmibank.pojo.US022.Customer;
import gmibank.pojo.US022.Tpcountry;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class US022_ReadStatesAPI {

    Response response;
    List<Customer> customers;


    @Given("In States user sets all response using end point {string}")
    public void setAllResponse(String endPoint) {
        response =
                given()
                        .auth().oauth2(ConfigurationReader.getProperty("token"))
                        .contentType(ContentType.JSON)
                        .when()
                        .get(endPoint)
                        .then()
                        .contentType(ContentType.JSON)
                        .statusCode(200)
                        .extract()
                        .response();

        //response.prettyPrint();
    }

    @When("In States user deserialization data json to java pojo")
    public void deserialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        customers = Arrays.asList(objectMapper.readValue(response.asString(), Customer[].class));
        for (Customer customer : customers)
            if (customer.getTpcountry() != null)
                System.out.println(customer.getTpcountry().getName());

    }


    @Then("In States user validates data")
    public void validate() {

        List<Integer> id= customers.stream().map(Customer::getId).collect(Collectors.toList());
        System.out.println("id "+id);
        List<String> name= customers.stream().map(Customer::getName).collect(Collectors.toList());
        System.out.println("name "+name);
        List<String> countryName= customers.stream().map(Customer::getTpcountry).filter(Objects::nonNull).map(Tpcountry::getName).collect(Collectors.toList());
        System.out.println("country name "+countryName);
        List<String> countryStates= customers.stream().map(Customer::getTpcountry).filter(Objects::nonNull).map(Tpcountry::getStates).collect(Collectors.toList());
        System.out.println("country states "+countryStates);
        Assert.assertTrue(countryName.contains("Netherlands"));
        Assert.assertTrue(name.contains("New York1"));
        if(name.equals("New York1")){
            response.prettyPrint();
        }
    }

    @Then("In States user validates data 1 by 1")
    public void validateDataBy() {

    }
}


