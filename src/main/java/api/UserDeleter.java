package api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserDeleter {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private final String USER_URI = "/api/auth/user";
    private final String LOGIN_URI = "/api/auth/login";

    private RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    private Response doPostRequest(String uri, String json) {
        return given()
                .spec(baseSpec())
                .body(json)
                .post(uri);
    }

    private Response doDeleteRequest(String uri, String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .spec(baseSpec())
                .delete(uri);
    }

    @Step("Авторизация пользователя")
    private Response loginUser(String email, String password) {
        String json = String.format("{ \"email\":  \"%s\", \"password\": \"%s\"}", email, password);
        return doPostRequest(LOGIN_URI, json);
    }

    @Step("Получение accessToken из тела ответа")
    private String getAccessTokenFromResponse(Response response) {
        return response.then().extract().path("accessToken");
    }

    @Step("Удаление пользователя")
    private Response deleteUser(String accessToken) {
        return doDeleteRequest(USER_URI, accessToken);
    }

    public void deleteUserPool(String email, String password) {
        Response response = loginUser(email, password);
        String token = getAccessTokenFromResponse(response);
        deleteUser(token);
    }
}
