package org.ardyan.model;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.ardyan.helper.Utilities;

import java.io.File;

import static org.ardyan.helper.Endpoint.appId;
import static org.ardyan.helper.Endpoint.baseUrl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiModel {
    private static RequestSpecification req;

    public static void setHeader() {
        req = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", appId);
    }

    public static Response getListUser() {
        setHeader();
        return req.get(baseUrl + "/user");
    }

    public static Response getSingleUser(String id) {
        setHeader();
        return req.get(baseUrl + "/user/" + id);
    }

    public static Response createUser(String firstName, String lastName, String email) {
        setHeader();
        String bodyJson = String.format("""
                {
                    "firstName": "%s",
                    "lastName": "%s",
                    "email": "%s"
                }
                """, firstName, lastName, email);
        return req.body(bodyJson).post(baseUrl + "/user/create");
    }

    public static Response deleteUser(String id) {
        setHeader();
        return req.delete(baseUrl + "/user/" + id);
    }

    public static void validationStatusCode(Response res, int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public static void validateStatusCodeOr(Response res, int code1, int code2) {
        assertThat(res.statusCode()).isIn(code1, code2);
    }

    public static void validateResponseJSONSchema(Response res, String filename) {
        File JSONFile = Utilities.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public static void validateErrorMessage(Response res, String errorMessage) {
        assertThat(res.jsonPath().getString("error").contains(errorMessage));
    }

    public static void validateDeletedId(Response res, String id) {
        assertThat(res.jsonPath().getString("id").contains(id));
    }
}
