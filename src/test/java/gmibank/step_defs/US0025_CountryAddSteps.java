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

import cucumber.api.java.en.Given;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.given;
public class US0025_CountryAddSteps  {
    Response response;
    JsonPath jsonPath;
    @Given("In States user sets all response using end point {string}")
    public void In_States_user_sets_all_response_using_end_point(String States_url) {
        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(States_url)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .response();
//        response.prettyPrint();
    }
    @Given("In States user deserialization data json to java pojo")
    public void In_States_user_deserialization_data_json_to_java_pojo() {
        jsonPath = response.jsonPath();
    }
    @Given("In States user validates data.")
    public void In_States_user_validates_data() {
//        //firstname value larini list halinde return eder
        List<Integer> listid = jsonPath.getList("id");
        System.out.println(listid);
//        //states icindeki name value larini list hainde return eder
        List<String> listname = jsonPath.getList("name");
        System.out.println(listname);
        List<String> listtpcountry = jsonPath.getList("tpcountry");
        System.out.println(listtpcountry);
        Assert.assertTrue("name kaydi yok", listname.contains("Auvergne"));
    }
//         "id": 25369,
//        "name": "Auvergne",
//        "tpcountry": null
}