package org.ardyan.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.ardyan.model.ApiModel;

import static org.ardyan.helper.Utilities.generateRandomEmail;

public class ApiStepDef {
    private Response response;

    @When("send GET request for get list user")
    public void sendGETRequestForGetListUser() {
        response = ApiModel.getListUser();
    }


    @Then("validate status code is {int}")
    public void validateStatusCodeIs(int status_code) {
        ApiModel.validationStatusCode(response, status_code);
    }

    @And("validate response with json schema {string}")
    public void validateResponseWithJsonSchema(String filename) {
        ApiModel.validateResponseJSONSchema(response, filename);
    }


    @When("send GET request for get single user with id {string}")
    public void sendGETRequestForGetSingleUserWithId(String id) {
        response = ApiModel.getSingleUser(id);
    }

    @Then("validate status code is {int} or {int}")
    public void validateStatusCodeIsOr(int statusCode1, int statusCode2) {
        ApiModel.validateStatusCodeOr(response, statusCode1, statusCode2);
    }

    @And("validate response body contain error message {string}")
    public void validateResponseBodyContainErrorMessage(String errorMessage) {
        ApiModel.validateErrorMessage(response, errorMessage);
    }

    @When("send POST request for create user with {string} and last name {string} and random email")
    public void sendPOSTRequestForCreateUser(String firstName, String lastName) {
        String email = generateRandomEmail(firstName, lastName);
        response = ApiModel.createUser(firstName, lastName, email);
    }

    @When("send POST request for create user with {string} and last name {string} and blank email")
    public void sendPOSTRequestForCreateUserInvalid(String firstName, String lastName) {
        String email = "";
        response = ApiModel.createUser(firstName, lastName, email);
    }

}
