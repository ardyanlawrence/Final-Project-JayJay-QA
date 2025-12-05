package org.ardyan.stepdef.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.ardyan.model.ApiModel;

import java.util.Objects;

import static org.ardyan.helper.Utilities.generateRandomEmail;

public class ApiStepDef {
    private Response response;
    private String createdUserId;

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

    @When("send POST request for create user with {string} and last name {string} and email {string}")
    public void sendPOSTRequestForCreateUser(String firstName, String lastName, String emailSpec) {
        String email = generateRandomEmail(firstName, lastName, emailSpec);
        response = ApiModel.createUser(firstName, lastName, email);
    }

    @And("store the created user id from response")
    public void store_the_created_user_id_from_response() {
        createdUserId = response.jsonPath().getString("id");
    }

    @Then("send DELETE request with id {string}")
    public void sendDELETERequestWithId(String id) {
        String deletedId;
        if (Objects.equals(id, "stored_id")) {
            deletedId = createdUserId;
        } else {
            deletedId = id;
        }
        response = ApiModel.deleteUser(deletedId);
    }

    @Then("validation response body contain deleted id {string}")
    public void validationResponseBodyContainDeletedId(String id) {
        String deletedId;
        if (Objects.equals(id, "stored_id")) {
            deletedId = createdUserId;
        } else {
            deletedId = id;
        }
        ApiModel.validateDeletedId(response, deletedId);
    }
}
