package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pojos.Country;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

public class US021_ReadCountriesAPI {

    Response response;
    List<Country> customers;
    @Given("In Countries user sets all response using end point {string}")
    public void setAllResponse(String endPoint) {
        response =
                given()
                        .auth().oauth2(ConfigurationReader.getProperty("api_bearer_token"))
                        .contentType(ContentType.JSON)
                        .when()
                        .get(endPoint)
                        .then()
                        .contentType(ContentType.JSON)
                        .statusCode(200)
                        .extract()
                        .response();
        response.prettyPrint();
    }
    @When("In Countries user deserialization data json to java pojo")
    public void deserialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        customers = Arrays.asList(objectMapper.readValue(response.asString(), Country[].class));
        for (Country customer : customers)
            if (customer.getName() != null)
                System.out.println(customer.getName());
    }
    @Then("In Countries user validates data")
    public void validate() {
        List<Integer> id = customers.stream().map(Country::getId).collect(Collectors.toList());
        System.out.println("id " + id);
        List<String> name = customers.stream().map(Country::getName).collect(Collectors.toList());
        System.out.println("name " + name);
        Assert.assertTrue("Doesn't contain expected country name", name.contains("Porto Rico"));
        Assert.assertTrue("Doesn't contain expected name", name.contains("Sweden"));
    }
    @Then("In Countries user validates data 1 by 1")
    public void validateDataBy() {
        String temp = "new zeland, HIMALAYALAYA, DOMINIC";
        List<String> expected =
                new ArrayList<>(Arrays.stream(temp.split(", ")).distinct().collect(Collectors.toList()));
        List<String> country =
                customers.stream().map(Country::getName).filter(Objects::nonNull).collect(Collectors.toList());
        Assert.assertTrue("Doesn't contain expected states", country.containsAll(expected));
    }
}