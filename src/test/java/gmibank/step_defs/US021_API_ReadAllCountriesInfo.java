package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojo.Country;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Order;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class US021_API_ReadAllCountriesInfo{

   private final static Logger log =Logger.getLogger(US021_API_ReadAllCountriesInfo.class);

     Country[] country;
     int countryID;
     Response response;
     JsonPath jp;
     ObjectMapper objectMapper = new ObjectMapper();
     String end_Point_Url = ConfigurationReader.getProperty("endPoint_Countries");
     List<Map<String,Object>> list ;

     @Order(1)
    @Given("User create new countries using in api end point {string}, {string} , {string}")
    public void userCreateNewCountriesUsingInApiEndPoint(String endPoint, String name, String country) {

        response=
                given()

                           .headers(
                                  "Authorization",
                                  "Bearer "+ ConfigurationReader.getProperty("token"),
                                  "Content-Type",
                                        ContentType.JSON)
                           .accept(ContentType.JSON)
                .when()
                           .body("{\""+name+"\":\""+country+"\"}")
                           .post(endPoint).
                then()

                           .body("name",is("France"))
                           .extract().response();

        System.out.println("response.statusCode() = " + response.statusCode());

         jp = response.jsonPath();
         countryID = jp.getInt("id");

        System.out.println("jp.getInt(\"id\") = " + countryID);
        response.prettyPrint();
    }

    @Order(2)
    @Then("User deserialization countries data json to pojo")
    public void user_deserialization_countries_data_json_to_pojo() throws IOException {
         objectMapper = new ObjectMapper();
         jp=response.jsonPath();
         country = objectMapper.readValue(response.asString(),Country[].class);

        for (int i =0; i<country.length; i++){
            if(country[i].getName() !=null) {
               // System.out.println("Countries Data :" + country[i].getName());
            }
            if (country[i].getState() !=null) {
              //  System.out.println("Country State :" + country[i].getState());
            }

           // System.out.println("Country ID :" + country[i].getId());
            System.out.println("Countries All Data :"+ country[i].toString());

        }

    }

    @Order(3)
    @Given("user read all countries and sets response using api end point {string}")
    public void userReadAllCountriesAndSetsResponseUsingApiEndPoint(String arg0) {

            response =    given().

                    headers(
                "Authorization",
                "Bearer "+ ConfigurationReader.getProperty("token"),
                "Content-Type",
                        ContentType.JSON).
                        accept(ContentType.JSON).
                when()
                        .get(end_Point_Url).
                then()
                       .extract().response();

        System.out.println("response.statusCode() = " + response.statusCode());
    }

    @Order(4)
    @Then("user validates all countries you created")
    public void userValidatesAllCountriesYouCreated() throws Exception {

        country = objectMapper.readValue(response.asString(),Country[].class);
        System.out.println("country length = " + country.length);


        jp = response.jsonPath();
        List<Integer> idList = jp.getList("id" , Integer.class) ;

        assertThat( "Must all ides match",idList , hasItems(73024, 73025, 73026));

        System.out.println("idList = " + idList);
    }
}
