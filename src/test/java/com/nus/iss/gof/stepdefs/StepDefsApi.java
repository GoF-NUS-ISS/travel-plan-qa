package com.nus.iss.gof.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StepDefsApi {
    RequestSpecification req_spec=null;
    Response resp=null;
    public String travel_api_server = "http://localhost:8001/";

    @Given("API is up and running")
    public void api_is_up_and_running() {
        req_spec= given().baseUri(travel_api_server);//.auth().oauth2(accessToken);
    }

    @When("User hit the api with post request with valid json body")
    public void user_hit_the_api_with_post_request_with_valid_json_body() {
        resp = req_spec.body("  {\n" +
                "    \"from\": \"NZ\",\n" +
                "    \"id\": \"1\",\n" +
                "    \"name\": \"akash\",\n" +
                "    \"to\": \"SG\"\n" +
                "  }").post("/travelPlan");
    }

    @Then("api returns {int} status code")
    public void api_returns_status_code(int code) {
        resp.then().assertThat().statusCode(code);
    }

    @When("User hit the api with get request with name query parameter value as {string}")
    public void user_hit_the_api_with_get_request_with_name_query_parameter_value_as(String value) {
        // Write code here that turns the phrase above into concrete actions
        resp = req_spec.when().get("/travelPlan/{name}/?name=" + value);
    }

    @Then("response body contains travel plan details for name {string}")
    public void response_body_contains_travel_plan_details_for_name(String string) {
        resp.then().assertThat().body("name",equalTo(string));
    }


}
