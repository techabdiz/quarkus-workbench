package org.packaege;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static groovyjarjarpicocli.CommandLine.ExitCode.OK;
import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.*;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class EndPointTest {

    @Test
    @DisplayName("should get all appearances")
    void getAllTest() {
        given()
                .header(ACCEPT, APPLICATION_JSON).when()
                .get("/spackage/all").then()
                .statusCode(200)
                .body("size()", is(2));
    }

    @Test
    @DisplayName("should count all appearances")
    void shouldCountAll(){
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .when()
                .get("/spackage/count")
                .then()
                .statusCode(200)
                .body("count", is(2));
    }

    @Test
    @DisplayName("should return object by id")
    void shouldReturnObjectById(){
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id","1")
                .when()
                .get("/spackage/get/{id}")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Corby, James"));
    }
}