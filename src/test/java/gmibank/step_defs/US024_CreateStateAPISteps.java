package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.*;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class US024_CreateStateAPISteps {
    Response response;
    @Given("user provides the Api endponit to set the response {string}")
    public void user_provides_the_Api_endponit_to_set_the_response(String endpoint) {
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
       response.prettyPrint();
    }

    @Given("user deserializes all states to pojo")
    public void user_deserializes_all_states_to_pojo() {

    }

    @Given("user generates all states' data in correspondent files")
    public void user_generates_all_states_data_in_correspondent_files() {

    }

    @Then("user validates data for all states")
    public void user_validates_data_for_all_states() {

    }
}
