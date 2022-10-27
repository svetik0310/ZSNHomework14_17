package restTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ZSNHomeworkRestTest {
    UserData user = new UserData("morpheus", "leader");
    UserEmailData email = new UserEmailData("eve.holt@reqres.in", "pistol");

    @BeforeAll
    void setUp() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @DisplayName("CreateUser")
    @Test
    void createUserSuccessfulTest() {
        given()
                .log().all()
                .contentType(JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().all()
                .statusCode(201)
                .body(
                        "name", is(user.getName()),
                        "job", is(user.getJob()),
                        //"id", is(emptyOrNullString()),
                        "createdAt", notNullValue()
                );
    }

    @DisplayName("GetUser")
    @Test
    void getUserTest() {
        given()
                .log().all()
                .contentType(JSON)
                .when()
                .get("/users/2")
                .then()
                .log().status()
                .log().all()
                .statusCode(200)
                .body(
                        "data.id", notNullValue()
                );
    }

    @DisplayName("DeleteUser")
    @Test
    void deleteUserSuccessfulTest() {
        given()
                .log().all()
                .contentType(JSON)
                .when()
                .delete("/users/7")
                .then()
                .log().status()
                .log().all()
                .statusCode(204);
    }

    @DisplayName("UpdateUser")
    @Test
    void updateUserSuccessfulTest() {
        given()
                .log().all()
                .contentType(JSON)
                .when()
                .put("/users/2")
                .then()
                .log().status()
                .log().all()
                .statusCode(200)
                .body(
                        "updatedAt", notNullValue()
                );
    }

    @DisplayName("RegistrationUser")
    @Test
    void userRegistrationSuccessfulTest() {

        given()
                .contentType(JSON)
                .body(email)
                .when()
                .post("/register")
                .then()
                .log().all()
                .statusCode(200)
                .body(
                        "id", notNullValue(),
                        "token", notNullValue()
                );
    }
}
