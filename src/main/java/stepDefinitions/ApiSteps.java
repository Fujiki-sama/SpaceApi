package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class ApiSteps {

    private static final String BASE_URL = "https://reqres.in/api";
    private RequestSpecification request;
    private Response response;

    @Given("I set the API endpoint for creating a user")
    public void setCreateUserEndpoint() {
        RestAssured.baseURI = BASE_URL + "/users";
    }

    @When("I send a POST request with valid user details")
    public void sendPostRequest() {
        String body = "{\"name\": \"Shavlego\", \"job\": \"QA Manual Engineer\"}";
        request = RestAssured.given().header("Content-Type", "application/json").body(body);
        response = request.post();
    }

    @Then("I should receive a 201 status code")
    public void validatePostStatusCode() {
        response.then().statusCode(201);
    }

    @Then("the response should contain the user details")
    public void validatePostResponse() {
        response.then().body("name", equalTo("Shavlego"))
                .body("job", equalTo("QA Manual Engineer"));
    }

    @Given("I set the API endpoint for retrieving a user")
    public void setGetUserEndpoint() {
        RestAssured.baseURI = BASE_URL + "/users";
    }

    @When("I send a GET request with user ID {string}")
    public void sendGetRequest(String userId) {
        response = RestAssured.given().get("/" + userId);
    }

    @Then("I should receive a 200 status code")
    public void validateGetStatusCode() {
        response.then().statusCode(200);
    }

    @Then("the response should contain the user ID {string}")
    public void validateGetResponse(String userId) {
        response.then().body("data.id", equalTo(Integer.parseInt(userId)));
    }

    @Given("I set the API endpoint for updating a user")
    public void setUpdateUserEndpoint() {
        RestAssured.baseURI = BASE_URL + "/users/2";
    }

    @When("I send a PUT request to update the user role")
    public void sendPutRequestToUpdateRole() {
        String body = "{\"name\": \"Shavlego\", \"job\": \"QA Automation Engineer\"}";

        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body);
        response = request.put();
    }
    @Then("the response should reflect the updated role")
    public void validateUpdatedRole() {
        response.then().statusCode(200)
                .body("job", equalTo("QA Automation Engineer"));
    }

    @Given("I set the API endpoint for deleting a user")
    public void setDeleteUserEndpoint() {
        RestAssured.baseURI = BASE_URL + "/users/2";
    }

    @When("I send a DELETE request with user ID {string}")
    public void sendDeleteRequest(String userId) {
        response = RestAssured.given().delete();
    }

    @Then("I should receive a 204 status code")
    public void validateDeleteStatusCode() {
        response.then().statusCode(204);
    }
}