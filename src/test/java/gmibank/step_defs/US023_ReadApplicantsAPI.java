package gmibank.step_defs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import static io.restassured.RestAssured.*;

public class US023_ReadApplicantsAPI {

Response responseAll;
    JsonPath jsonPath;

    @When("user sets all applicants response using end point {string}")
    public void user_sets_all_applicants_response_using_end_point(String endPoint) {
        responseAll =
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

        responseAll.prettyPrint();
    }


    @Then("user validates all applicants data")
    public void user_validates_all_applicants_data() {
        jsonPath= responseAll.jsonPath();
        String id = jsonPath.getString("userId");
        String firstName = jsonPath.getString("firstName");
        String lastName = jsonPath.getString("lastName");
        String address = jsonPath.getString("address");
        String address1 = jsonPath.getString("address");
        assertTrue(id.contains("USA"));
    }

    @Then("user validates data 1 by 1")
    public void user_validates_data_by(Integer int1, Integer int2) {
        jsonPath= responseAll.jsonPath();


    }
}
