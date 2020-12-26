package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pojos.Country;
import gmibank.pojos.States;
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

public class US022_ReadStatesAPI {
	Response response;
	List<States> customers;
	
	@Given("In States user sets all response using end point {string}")
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
	
	@When("In States user deserialization data json to java pojo")
	public void deserialization() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		customers = Arrays.asList(objectMapper.readValue(response.asString(), States[].class));
		for (States customer : customers)
			if (customer.getTpcountry() != null)
				System.out.println(customer.getTpcountry().getName());
	}
	
	@Then("In States user validates data")
	public void validate() {
		List<Integer> id = customers.stream().map(States::getId).collect(Collectors.toList());
		System.out.println("id " + id);
		List<String> name = customers.stream().map(States::getName).collect(Collectors.toList());
		System.out.println("name " + name);
		List<String> countryName =
				customers.stream().map(States::getTpcountry).filter(Objects::nonNull).map(Country::getName).collect(Collectors.toList());
		System.out.println("country name " + countryName);
		List<String> countryStates =
				customers.stream().map(States::getTpcountry).filter(Objects::nonNull).map(Country::getName).collect(Collectors.toList());
		System.out.println("country states " + countryStates);
		Assert.assertTrue("Doesn't contain expected country name", countryName.contains("Urfali Pasa"));
		Assert.assertTrue("Doesn't contain expected name", name.contains("texas"));
	}
	
	@Then("In States user validates data 1 by 1")
	public void validateDataBy() {
		String temp = "Urfali Pasa, Urfali Pasa, FR, FR, FR, Urfali Pasa, Urfali Pasa, Urfali Pasa, Urfali Pasa, " +
				"Urfali Pasa, USA, Urfali Pasa";
		List<String> expected =
				new ArrayList<>(Arrays.stream(temp.split(", ")).distinct().collect(Collectors.toList()));
		List<String> countryStates =
				customers.stream().map(States::getTpcountry).filter(Objects::nonNull).map(Country::getName).collect(Collectors.toList());
		Assert.assertTrue("Doesn't contain expected states", countryStates.containsAll(expected));
	}
}
