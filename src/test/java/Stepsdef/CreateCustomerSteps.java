package Stepsdef;

import Utils.ApiHeper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class CreateCustomerSteps {

    private ApiHeper apiHelper = new ApiHeper();

    @When("i post request to create a customer using json file")
    public void i_post_request_to_create_a_customer_using_json_file() {
        apiHelper.performPostRequestUsingConstants();
    }

    @Then("i should be able to create a customer")
    public void i_should_be_able_to_create_a_customer() throws IOException {
        apiHelper.performPostRequest();
    }

    @Then("i should get {int} response")
    public void i_should_get_response(int  responseCode) {
        apiHelper.validateResponseCode(responseCode);
    }

}
