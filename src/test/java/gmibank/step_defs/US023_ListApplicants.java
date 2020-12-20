package gmibank.step_defs;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.itextpdf.text.log.SysoCounter;
import cucumber.api.java.en.*;
import gmibank.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class US023_ListApplicants {
static String url="https://gmibank.com/account";
  static String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjIiLCJhdXRoIjoiUk9MRV9BRE1JTixST0xFX0NVU1RPTUVSLFJPTEVfRU1QTE9ZRUUsUk9MRV9NQU5BR0VSLFJPTEVfVVNFUiIsImV4cCI6MTYwNjM4OTkwOH0.ZU_1xa-pKN0dcaKEmH0Hm1ILU5JTXAZQ9L6guYZtCglvEasI5vwvFVAKrlY2SgtSnW_iBV7WMgmSz23h7ft5NA";
   static RequestSpecification request;
  static Response response;

    @Given("User can connect to Api with given token")
    public void user_can_connect_to_Api_with_given_token() {
       /*  Response response = given().headers(
               "Authorisation",
                "Bearer"+ ConfigurationReader.getProperty("token"),
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
        System.out.println(response.prettyPrint());
//
          */

        /*     RestAssured.baseURI=URL; //(1st sent. to declare the URI with Rest Assured )

               RequestSpecification httpRequest=RestAssured.given(); //(second sentence to form http Request )
               Response response=httpRequest.request(Method.GET,"/"+"register");// (to form response )
        //String rBody=response.getBody().asString(); // ( store response to a string )

        System.out.println("Response Body is :" + rBody);
        */

        request= given().header("Content-Type","Application/json").
                header("Authorization",token);
        System.out.println("First Test Passed");

    }

    @When("User can get response")
    public void user_can_get_response() {
        response=request.when().get(url);
        response.prettyPrint();
        //System.out.println("Response is "+ response);

      /*  JSONObject json = new JSONObject(response.prettyPrint());
        JSONArray array =json.getJSONArray("Applicants");
        System.out.println("Size of list for returned Employee is: "+array.length());
        for (int i=0; i<= array.length()-1; i++){
            String aplicant=response.jsonPath().getString("Applicant["+i+"].Applicants");
            System.out.println("Applicant Name is : "+aplicant);

        }*/



    }

    @Then("user can list all applicants")
    public void user_can_list_all_applicants() {

    }


}
