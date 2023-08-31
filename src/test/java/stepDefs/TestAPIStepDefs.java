package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class TestAPIStepDefs {
    private Response res;

    @Given("I setup the payload")
    public void iSetupThePayload() {
        System.out.println("I setup the payload");
    }

    @When("I send a POST request to endpoint")
    public void iSendAPOSTRequestToEndpoint() {


        String request = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        res = given().contentType(ContentType.JSON)
                .body(request)
                .when().get("https://reqres.in/api/users")
                .then().extract().response();
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        System.out.println("the response status is " + res.getStatusCode());
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(), statusCode);

    }
}
