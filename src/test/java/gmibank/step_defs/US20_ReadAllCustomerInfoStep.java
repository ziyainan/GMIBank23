package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class US20_ReadAllCustomerInfoStep {

    Response response;

    @Given("user provides the api end point to set the response {string}")
    public void user_provides_the_api_end_point_to_set_the_response(String url) {

        response = given().headers(
                    "Authorization",
                    "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                    "Content-Type",
                    ContentType.JSON,
                    "Accept",
                    ContentType.JSON).
                when().
                    get(url).
                then().
                    contentType(ContentType.JSON).
                    extract().
                    response();

        response.prettyPrint();
    }

    @Given("validate them from your data set")
    public void validate_them_from_your_data_set() {


    }


}
