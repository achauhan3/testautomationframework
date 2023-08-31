package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.CreateUsers;

import static io.restassured.RestAssured.given;

public class TestAPIStepDefs {
    private Response res;

    @Given("I setup the payload")
    public void iSetupThePayload() {
        System.out.println("I setup the payload");
    }

    @When("I send a POST request to endpoint")
    public void iSendAPOSTRequestToEndpoint() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String request = objectMapper.writeValueAsString(new CreateUsers("Abhishek", "testing"));

        System.out.println(request);

        res = given().contentType(ContentType.JSON)
                .body(request)
                .when().post("https://reqres.in/api/users")
                .then().extract().response();
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        System.out.println("the response status is " + res.getStatusCode());
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(), statusCode);

    }

    @When("I send a GET request to endpoint")
    public void iSendAGETRequestToEndpoint() {
        res = given().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users")
                .then().extract().response();
    }
}
