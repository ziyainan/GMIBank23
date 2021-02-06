package gmibank.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtil {

   protected static String endPointCountries=ConfigurationReader.getProperty("endPoint_Countries");

   protected static String token=ConfigurationReader.getProperty("token");

  protected static RequestSpecification reqSpace = new RequestSpecBuilder().
                     setBaseUri(ConfigurationReader.getProperty("endPoint_Countries")).build();

  static Response response;

    public static void createCountry(Integer id, String country, String states) {
             reqSpace = new RequestSpecBuilder()
                            .setBaseUri(endPointCountries)
                            .build();

        Map<String, Object> req = new HashMap<>();
        req.put("id", id);
        req.put("name", country);
        req.put("states", states);

         response =
                given()
                        .contentType(ContentType.JSON)
                        .spec(reqSpace)
                        .auth().oauth2((token))
                        .body(req).
                when()
                        .post();

                 response.prettyPrint();

    }

    public static void readAllCountries(){
        response =
                given()
                         .auth().oauth2(token)
                         .accept(ContentType.JSON).
                when()
                         .get(endPointCountries);
        response.prettyPrint();

    }

    public static void  actualCountry(int param){
        reqSpace.pathParam("id",param);
        response =
                   given()
                          .spec(reqSpace)
                          .auth().oauth2(token).
                   when()
                          .get("/{id}");
        response.prettyPrint();
    }

    public static String getTokenEmployee(){
      String username = ConfigurationReader.getProperty("EmployeeUsername");
       String password = ConfigurationReader.getProperty("EmployeePassword");

       Response jsonResponse = given()
                                      .contentType(ContentType.URLENC)
                                      .formParam("username",username)
                                      .formParam("password", password).
                               when()
                                      .post("https://www.gmibank.com");

        JsonPath jsonPath = jsonResponse.jsonPath();
        String token = jsonPath.getString("token");

        return token;
    }


}
